package com.example.btlnguyenducthang.model;

import android.net.Uri;
import android.provider.MediaStore;

public class Album extends BaseModel {
    @FieldInfo(columnName = MediaStore.Audio.Albums._ID)
    private int IdAlbum;
    @FieldInfo(columnName = MediaStore.Audio.Albums.ALBUM)
    private String ten;
    @FieldInfo(columnName = MediaStore.Audio.Albums.NUMBER_OF_SONGS)
    private int soBaihat;
    @FieldInfo(columnName = MediaStore.Audio.Albums.ARTIST)
    private String ngheSi;
    @FieldInfo(columnName = MediaStore.Audio.Albums.ARTIST_ID)
    private int idNgheSi;

    public int getIdAlbum() {
        return IdAlbum;
    }

    public String getTen() {
        return ten;
    }

    public int getSoBaihat() {
        return soBaihat;
    }

    public String getNgheSi() {
        return ngheSi;
    }

    public int getIdNgheSi() {
        return idNgheSi;
    }

    @Override
    public Uri getContentUri() {
        return MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI;
    }
}
