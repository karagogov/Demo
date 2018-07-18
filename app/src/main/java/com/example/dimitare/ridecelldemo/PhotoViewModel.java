package com.example.dimitare.ridecelldemo;

import android.databinding.BaseObservable;
import android.databinding.Observable;
import android.databinding.ObservableField;

import com.example.dimitare.ridecelldemo.data.Photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoViewModel extends BaseObservable implements SearchDataSourse.LoadSearchListCallback {
    private final SearchRepository mSearchRepository;
    private PhotoList mPhotoList;
    private boolean mIsLoading;
    private final ObservableField<List<Photo>> mPhotosObservable = new ObservableField<>();


    public PhotoViewModel(SearchRepository searchRepository) {
        mSearchRepository = searchRepository;
    }

    @Override
    public void onImagesListLoaded(List<Photo> photoList) {
        mPhotosObservable.addOnPropertyChangedCallback(new OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                List<Photo> photos = mPhotosObservable.get();
                if (mPhotoList != null && photos != null) {
                    mPhotoList.updateList(photos);
                    notifyPropertyChanged(BR.photos);
                    notifyChange();
                } else {
                    //show error
                }
            }
        });
        mPhotosObservable.set(photoList);
    }

    @Override
    public void onDataNotAvailable() {

    }

    @Override
    public void onDataLoading() {

    }

    public void start() {
        loadPhotos(false, "");
    }

    public void loadPhotos(boolean forceUpdate, String query) {
        loadPhotos(forceUpdate, query, true);
    }

    private void loadPhotos(boolean forceUpdate, String query, final boolean showLoading) {
        if (showLoading) {
            //dataLoading.set(true);
        }
        if (forceUpdate) {
            mSearchRepository.refreshPhotos();
        }
        if( mPhotoList != null ){
            mPhotoList.removeAllPhotos(new ArrayList<Photo>());
            notifyPropertyChanged(BR.photos);
        }
        mSearchRepository.getPhotoList(this, query);
    }

    public void setPhotoList(PhotoList photoList) {
        mPhotoList = photoList;
    }
}
