package com.example.btlnguyenducthang.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.btlnguyenducthang.R;
import com.example.btlnguyenducthang.base.BaseBindingAdapter;
import com.example.btlnguyenducthang.base.BaseFragment;
import com.example.btlnguyenducthang.databinding.FragmentAlbumBinding;
import com.example.btlnguyenducthang.model.Album;

public class AlbumFragment extends BaseFragment<FragmentAlbumBinding,AlbumViewModel> {
    private BaseBindingAdapter<Album> adapter;

    @Override
    protected Class<AlbumViewModel> getViewModelClass() {
        return AlbumViewModel.class;
    }
    @Override
    protected int getLayoutID() {
        return R.layout.fragment__album;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter=new BaseBindingAdapter<>(
                R.layout.item_album,getLayoutInflater());
        binding.setAdapter(adapter);
        adapter.setData(viewModel.getAlbums(getContext()));
    }
}
