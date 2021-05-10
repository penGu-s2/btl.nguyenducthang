package com.example.btlnguyenducthang.ui.fragment;

import android.content.Context;

import com.example.btlnguyenducthang.base.BaseViewModel;
import com.example.btlnguyenducthang.model.NgheSi;
import com.example.btlnguyenducthang.service.SystemData;

import java.util.ArrayList;

public class ArtistViewModel extends BaseViewModel {
    private ArrayList<NgheSi> ngheSis;

    public ArrayList<NgheSi> getArtist(Context context) {
        if (ngheSis == null) {
            SystemData data = new SystemData(context);
            ngheSis = data.getData(NgheSi.class);
        }
        return ngheSis;
    }
}
