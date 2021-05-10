package com.example.btlnguyenducthang.ui.fragment;

import android.content.Context;

import com.example.btlnguyenducthang.base.BaseViewModel;
import com.example.btlnguyenducthang.model.Song;
import com.example.btlnguyenducthang.service.SystemData;

import java.util.ArrayList;

public class SongViewModel extends BaseViewModel {
    private ArrayList<Song> songs;

    public ArrayList<Song> getSong(Context context) {
        if (songs == null) {
            SystemData data = new SystemData(context);
            songs = data.getData(Song.class);
        }
        return songs;
    }

}