package com.example.btlnguyenducthang.service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.widget.RemoteViews;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.MutableLiveData;

import com.example.btlnguyenducthang.acitvity.MediaController;
import com.example.btlnguyenducthang.model.Song;
import com.example.btlnguyenducthang.R;

import java.util.ArrayList;

public class Mp3Service extends Service {

    private MediaController controller;
    private RemoteViews remoteViews;

    private final  String NEXT="action.NEXT";
    private final  String PREV="action.PREV";
    private final  String PLAY="action.PLAY";
    private final  String CLOSE="action.CLOSE";

    private MutableLiveData<MediaController> liveData=new MutableLiveData<>();
    private boolean isRunning;

    @Override
    public void onCreate() {
        super.onCreate();
        initRemoteViews();

        IntentFilter filter=new IntentFilter();
        filter.addAction(NEXT);
        filter.addAction(PREV);
        filter.addAction(PLAY);
        filter.addAction(CLOSE);

        registerReceiver(receiver,filter);

    }

    private void initRemoteViews() {
        remoteViews =new RemoteViews(getPackageName(), R.layout.ui_notifi);
        registerAction(R.id.im_close,CLOSE);
        registerAction(R.id.im_next,NEXT);
        registerAction(R.id.im_prev,PREV);
        registerAction(R.id.im_play,PLAY);

    }
    private void registerAction(@IdRes int id, String action) {
        Intent intent = new Intent(action);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT
        );
        remoteViews.setOnClickPendingIntent(id, pendingIntent);
    }

    private void pushNotify(Song song){
        Intent intent=new Intent(this,getClass());
        startService(intent);

        String channelId="Mp3Channel";
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    channelId,
                    NotificationManager.IMPORTANCE_LOW
            );
            manager.createNotificationChannel(channel);
        }
        remoteViews.setTextViewText(R.id.tv_song, song.getTen());
        remoteViews.setTextViewText(R.id.tv_artist, song.getNgheSi());
        if (controller.isPlaying()) {
            remoteViews.setImageViewResource(R.id.im_play, R.drawable.play);
        } else {
            remoteViews.setImageViewResource(R.id.im_play, R.drawable.play);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(
                this,
                channelId
        );
        builder.setSmallIcon(R.drawable.play);
        builder.setCustomContentView(remoteViews);
        startForeground(1221, builder.build());
    }

    public void setData(final ArrayList<Song>songs){
        if(controller ==null){
            controller=new MediaController(songs,this){
                @Override
                public void create(int i) {
                    super.create(i);
                    if(isRunning==false){
                        isRunning=true;
                        Thread t=new Thread(run);
                        t.start();
                    }
                }

                @Override
                public void pause() {
                    super.pause();
                    pushNotify(songs.get(i));
                }

                @Override
                public void start() {
                    super.start();
                    pushNotify(songs.get(i));
                }
            };
        }
    }
    public MutableLiveData<MediaController> getLiveController() {
        return liveData;
    }
    private Runnable run = new Runnable() {
        @Override
        public void run() {
            while (true) {
                liveData.postValue(controller);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    public MediaController getController() {
        return controller;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (controller != null) {
            controller.release();
        }
        unregisterReceiver(receiver);
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MP3Binder(this);
    }
    public class MP3Binder extends Binder {
        private Mp3Service service;

        public MP3Binder(Mp3Service service) {
            this.service = service;
        }

        public Mp3Service getService() {
            return service;
        }
    }
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()) {
                case CLOSE:
                    stopForeground(true);
                    controller.release();
                    controller = null;
                    liveData.postValue(null);
                    stopSelf();
                    break;
                case NEXT:
                    controller.change(1);
                    break;
                case PREV:
                    controller.change(-1);
                    break;
                case PLAY:
                    if (controller.isPlaying()) {
                        controller.pause();
                    } else {
                        controller.start();
                    }
                    break;
            }
        }
    };
}
