package com.example.dimitare.ridecelldemo;

import android.support.annotation.NonNull;

import com.example.dimitare.ridecelldemo.data.Photo;
import com.example.dimitare.ridecelldemo.data.PhotoInfo;

import java.util.List;

public interface SearchDataSourse {
    interface LoadSearchListCallback {

        void onImagesListLoaded(List<Photo> photoList);

        void onDataNotAvailable();

        void onDataLoading();
    }

    interface LoadPhotoInfoCallback{

        void onImagesInfoLoaded(PhotoInfo photoInfo);

        void onDataNotAvailable();

        void onDataLoading();
    }

    void getPhotoList(@NonNull LoadSearchListCallback callback, @NonNull String query);

    void getPhotoInfo(@NonNull LoadPhotoInfoCallback callback, @NonNull String photoId);
}
