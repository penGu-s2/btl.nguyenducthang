package com.example.btlnguyenducthang.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.btlnguyenducthang.R;
import com.example.btlnguyenducthang.base.BaseBindingAdapter;
import com.example.btlnguyenducthang.base.BaseFragment;
import com.example.btlnguyenducthang.databinding.FragmentArtistBinding;
import com.example.btlnguyenducthang.model.NgheSi;

public class ArtistFragment extends BaseFragment<FragmentArtistBinding, ArtistViewModel> {

    private BaseBindingAdapter<NgheSi> adapter;

    @Override
    protected Class<ArtistViewModel> getViewModelClass() {
        return ArtistViewModel.class;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_artist;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new BaseBindingAdapter<>(
                R.layout.item_artist, getLayoutInflater());
        binding.setAdapter(adapter);
        adapter.setData(viewModel.getArtist(getContext()));
    }
}