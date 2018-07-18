package com.example.dimitare.ridecelldemo;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.dimitare.ridecelldemo.data.Photo;
import com.example.dimitare.ridecelldemo.data.PhotoInfo;
import com.example.dimitare.ridecelldemo.data.RawPhotos;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import static android.support.v4.util.Preconditions.checkNotNull;

public class SearchRepository implements SearchDataSourse {
    @NonNull
    private PhotoService mPhotoServer;
    boolean mCacheIsDirty = false;

    @NonNull
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();


    @SuppressLint("RestrictedApi")
    @Override
    public void getPhotoList(@NonNull final LoadSearchListCallback callback, @NonNull String query) {
        checkNotNull(callback);
        if (!mCacheIsDirty) {
            callback.onDataLoading();
            return;
        }
        mPhotoServer = new RetrofitHelper().getPhotoService("https://api.flickr.com/services/rest/");
        mCompositeDisposable.add(mPhotoServer.getPhotos(query)
                .subscribeOn(Schedulers.io()) // "work" on io thread
                .observeOn(AndroidSchedulers.mainThread()) // "listen" on UIThread
                .map(new Function<RawPhotos, List<Photo>>() {
                    @Override
                    public List<Photo> apply(RawPhotos rawPhotos) throws Exception {
                        if( rawPhotos != null && rawPhotos.getPhotos() != null ){
                            return rawPhotos.getPhotos().getPhoto();
                        }
                        return null;
                    }
                })
                .subscribe(new Consumer<List<Photo>>() {
                    @Override
                    public void accept(List<Photo> photos) throws Exception {
                        if( callback != null ) {
                            callback.onImagesListLoaded(new ArrayList<Photo>(photos));
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable)  {
                        Log.w(this.getClass().toString(), this.getClass().toString());
                    }
                })
        );
    }

    @Override
    public void getPhotoInfo(@NonNull final LoadPhotoInfoCallback callback, @NonNull String photoId) {
        mPhotoServer = new RetrofitHelper().getPhotoService("https://api.flickr.com/services/rest/");
        mCompositeDisposable.add(mPhotoServer.getPhotoInfo(photoId)
                .subscribeOn(Schedulers.io()) // "work" on io thread
                .observeOn(AndroidSchedulers.mainThread()) // "listen" on UIThread
                .map(new Function<PhotoInfo, PhotoInfo>() {
                    @Override
                    public PhotoInfo apply(PhotoInfo photoInfo) throws Exception {
                        return photoInfo;
                    }
                })
                .subscribe(new Consumer<PhotoInfo>() {
                    @Override
                    public void accept(PhotoInfo photoInfo) throws Exception {
                        if( callback != null ) {
                            callback.onImagesInfoLoaded(photoInfo);
                        }
                        resetPhotos();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable)  {
                        resetPhotos();
                        Log.w(this.getClass().toString(), this.getClass().toString());
                    }
                })
        );
    }

    public void resetPhotos(){
        mCacheIsDirty = false;
    }

    public void refreshPhotos() {
        mCacheIsDirty = true;
    }
}
