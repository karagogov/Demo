package com.example.dimitare.ridecelldemo;

import com.example.dimitare.ridecelldemo.data.PhotoInfo;
import com.example.dimitare.ridecelldemo.data.RawPhotos;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PhotoService {
    @GET("?&method=flickr.photos.getRecent&api_key=6bf318919bbbc455f3573d18798a58e3&format=json&nojsoncallback=?")
    Single<RawPhotos> getPhotos(@Query("q") String photoSearch);



    @GET("?&method=flickr.photos.getInfo&api_key=6bf318919bbbc455f3573d18798a58e3&format=json&nojsoncallback=?")
    Single<PhotoInfo> getPhotoInfo(@Query("photo_id") String photoId);
}
