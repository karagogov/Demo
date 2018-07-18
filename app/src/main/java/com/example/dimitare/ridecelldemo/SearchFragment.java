package com.example.dimitare.ridecelldemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dimitare.ridecelldemo.databinding.SearchViewBinding;

public class SearchFragment extends Fragment {
    private PhotoViewModel mPhotoViewModel;
    private SearchViewBinding mBinding;

    public void setViewModel(PhotoViewModel mediaViewModel) {
        mPhotoViewModel = mediaViewModel;
        PhotoList photoList = new PhotoList();
        mPhotoViewModel.setPhotoList(photoList);
        mBinding.setModelView(mPhotoViewModel);
        mBinding.setPhotos(photoList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = SearchViewBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPhotoViewModel.start();
    }

    public void findFlikrPhotos(String newText) {
        mPhotoViewModel.loadPhotos(true, newText);
    }
}
