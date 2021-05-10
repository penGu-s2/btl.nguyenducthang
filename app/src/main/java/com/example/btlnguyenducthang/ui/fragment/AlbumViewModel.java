package com.example.btlnguyenducthang.ui.fragment;

import android.content.Context;

import com.example.btlnguyenducthang.base.BaseViewModel;
import com.example.btlnguyenducthang.model.Album;
import com.example.btlnguyenducthang.service.SystemData;

import java.util.ArrayList;

public class AlbumViewModel extends BaseViewModel {
    private ArrayList<Album> albums;

    public ArrayList<Album> getAlbums(Context context){
        if(albums==null){
            SystemData data=new SystemData(context);
            albums=data.getData(Album.class);
        }
        return albums;
    }
}
