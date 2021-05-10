package com.example.btlnguyenducthang.model;

import android.net.Uri;
import android.provider.MediaStore;

public class Song extends BaseModel {
    @FieldInfo(columnName = MediaStore.Audio.Media._ID)
    private int idBaiHat;
    @FieldInfo(columnName = MediaStore.Audio.Media.DATA)
    private String data;
    @FieldInfo(columnName = MediaStore.Audio.Media.TITLE)
    private String ten;
    @FieldInfo(columnName = MediaStore.Audio.Media.SIZE)
    private int kichco;
    @FieldInfo(columnName = MediaStore.Audio.Media.DURATION)
    private int time;
    @FieldInfo(columnName = MediaStore.Audio.Media.ALBUM)
    private String album;
    @FieldInfo(columnName = MediaStore.Audio.Media.ARTIST)
    private String ngheSi;
    @FieldInfo(columnName = MediaStore.Audio.Media.ALBUM_ID)
    private int idAlbum;

    public int getIdBaiHat() {
        return idBaiHat;
    }

    public String getData() {
        return data;
    }

    public String getTen() {
        return ten;
    }

    public int getKichco() {
        return kichco;
    }

    public int getTime() {
        return time;
    }

    public String getAlbum() {
        return album;
    }

    public String getNgheSi() {
        return ngheSi;
    }

    public int getIdAlbum() {
        return idAlbum;
    }

    @Override
    public Uri getContentUri() {
        return MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
    }
}

