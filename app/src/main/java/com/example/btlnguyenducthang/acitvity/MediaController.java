package com.example.btlnguyenducthang.acitvity;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

import com.example.btlnguyenducthang.model.Song;

import java.util.ArrayList;

public class MediaController implements MediaPlayer.OnCompletionListener {

    private ArrayList<Song> Songs;
    private Context context;
    private MediaPlayer player;
    public int i;

    public MediaController(ArrayList<Song> Songs,Context context){
        this.Songs=Songs;
        this.context=context;
    }
    public void create(int i){
        release();
        this.i=i;
        Uri uri= Uri.parse(Songs.get(i).getData());
        player=MediaPlayer.create(context,uri);
        start();
        player.setOnCompletionListener(this);
    }

    public void start() {
        if(player!=null){
            player.start();
        }
    }

    public void release() {
        if(player!=null){
            player.release();
        }
    }
    public void stop() {
        if (player != null) {
            player.stop();
        }
    }

    public void pause() {
        if (player != null) {
            player.pause();
        }
    }
    public void loop(boolean isLooping) {
        if (player != null) {
            player.setLooping(isLooping);
        }
    }

    public void seek(int position) {
        if (player != null) {
            player.seekTo(position);
        }
    }
    public String getTenSong(){
        return Songs.get(i).getTen();
    }
    public boolean isPlaying(){
        return player==null?false:player.isPlaying();
    }
    public int getThoiGian(){
        return player==null?0:player.getDuration();
    }
    public int getPosition() {
        return player == null ? 0 : player.getCurrentPosition();
    }
    public void change(int value){
        i+=value;
        if(i<0){
            i=Songs.size()-1;
        }else
            if (i>=Songs.size()){
                i=0;
            }
            create(i);
    }
    @Override
    public void onCompletion(MediaPlayer mp) {
    change(1);
    }
}
