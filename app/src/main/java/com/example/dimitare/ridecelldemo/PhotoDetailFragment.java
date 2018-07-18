package com.example.dimitare.ridecelldemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dimitare.ridecelldemo.databinding.PhotoDetailsViewBinding;

public class PhotoDetailFragment extends Fragment {
    private PhotoDetailsViewBinding mBinding;
    public static final String ARGUMENT_PHOTO_ID = "PHOTO_ID";
    private String mPhotoId;

    private PhotoDetailViewModel mPhotoDetailViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = PhotoDetailsViewBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    public static PhotoDetailFragment newInstance(String photoId) {
        Bundle arguments = new Bundle();
        arguments.putString(ARGUMENT_PHOTO_ID, photoId);
        PhotoDetailFragment fragment = new PhotoDetailFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    public void setViewModel(PhotoDetailViewModel photoDetailViewModel) {
        mPhotoDetailViewModel = photoDetailViewModel;
        mBinding.setModelView(mPhotoDetailViewModel);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPhotoDetailViewModel.start(( mPhotoId != null && mPhotoId.length()> 0 ) ? mPhotoId: getArguments().getString(ARGUMENT_PHOTO_ID));
    }

    public void setPhotoId(String photoId) {
        mPhotoId = photoId;
    }
}
