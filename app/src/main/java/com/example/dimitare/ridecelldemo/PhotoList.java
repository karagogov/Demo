package com.example.dimitare.ridecelldemo;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dimitare.ridecelldemo.data.Photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoList extends BaseObservable {
    public ObservableArrayList<Photo> mPhotos = new ObservableArrayList<>();
    public ObservableField<String> mTest = new ObservableField<>();

    @BindingAdapter("bind:photoItems")
    public static void bindList(RecyclerView view, PhotoList list) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        view.setLayoutManager(layoutManager);
        PhotoItemNavigator navigator = view.getContext() instanceof  PhotoItemNavigator ? (PhotoItemNavigator) view.getContext() : null;
        view.setAdapter(new PhotosAdapter(list, navigator));
    }

    public void updateList(List<Photo> photos) {
        for( int i = 0; i < photos.size(); i++ ){
            mPhotos.add(photos.get(i));
        }
        notifyChange();
    }

    public void removeAllPhotos(ArrayList<Photo> photos) {
        mPhotos.clear();
    }
}
