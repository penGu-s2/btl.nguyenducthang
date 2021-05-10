package com.example.btlnguyenducthang.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.btlnguyenducthang.R;
import com.example.btlnguyenducthang.acitvity.MainActivity;
import com.example.btlnguyenducthang.base.BaseBindingAdapter;
import com.example.btlnguyenducthang.base.BaseFragment;
import com.example.btlnguyenducthang.databinding.FragmentSongBinding;
import com.example.btlnguyenducthang.model.Song;
import com.example.btlnguyenducthang.service.MediaListener;

public class SongFragment extends BaseFragment<FragmentSongBinding, SongViewModel> implements MediaListener<Song> {

    private BaseBindingAdapter<Song> adapter;

    @Override
    protected Class<SongViewModel> getViewModelClass() {
        return SongViewModel.class;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_song;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter=new BaseBindingAdapter<>(
                R.layout.item_song,getLayoutInflater()
        );
        binding.setAdapter(adapter);
        adapter.setListener(this);
        adapter.setData(viewModel.getSong(getContext()));
    }

    @Override
    public void onItemMediaClicked(Song item) {
        MainActivity activity = (MainActivity) getActivity();
        activity.getService().setData(adapter.getData());
        activity.getService().getController()
                .create(adapter.getData().indexOf(item));
    }
}