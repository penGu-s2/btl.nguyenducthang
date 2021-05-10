package com.example.btlnguyenducthang.service;

import com.example.btlnguyenducthang.base.BaseBindingAdapter;
import com.example.btlnguyenducthang.model.BaseModel;

public interface MediaListener <T extends BaseModel>
        extends BaseBindingAdapter.BaseBindingListener {
    void onItemMediaClicked(T item);
}
