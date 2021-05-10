package com.example.btlnguyenducthang.model;

import android.net.Uri;
import android.provider.MediaStore;

public class NgheSi extends BaseModel {

    @FieldInfo(columnName = MediaStore.Audio.Artists._ID)
    private int idNgheSi;
    @FieldInfo(columnName = MediaStore.Audio.Artists.ARTIST)
    private String ten;
    @FieldInfo(columnName = MediaStore.Audio.Artists.NUMBER_OF_ALBUMS)
    private int slAlbum;
    @FieldInfo(columnName = MediaStore.Audio.Artists.NUMBER_OF_TRACKS)
    private int slBaiHat;

    public int getIdNgheSi() {
        return idNgheSi;
    }

    public String getTen() {
        return ten;
    }

    public int getSlAlbum() {
        return slAlbum;
    }

    public int getSlBaiHat() {
        return slBaiHat;
    }

    @Override
    public Uri getContentUri() {
        return null;
    }
}
