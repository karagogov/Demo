package com.example.dimitare.ridecelldemo;

import android.database.Observable;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.widget.ImageView;

import com.example.dimitare.ridecelldemo.data.PhotoInfo;
import com.example.dimitare.ridecelldemo.data.PhotoInfoPhoto;
import com.example.dimitare.ridecelldemo.utils.Utils;
import com.squareup.picasso.Picasso;

public class PhotoDetailViewModel extends BaseObservable implements SearchDataSourse.LoadPhotoInfoCallback {
    private final SearchRepository mSearchRepository;
    public ObservableField<String> userName = new ObservableField<>();
    public ObservableField<String> photoUrl = new ObservableField<>();
    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String> subtitle = new ObservableField<>();

    public PhotoDetailViewModel(SearchRepository searchRepository) {
        mSearchRepository = searchRepository;
    }

    public void start(String photoId) {
        mSearchRepository.getPhotoInfo(this, photoId);
    }

    @Override
    public void onImagesInfoLoaded(PhotoInfo photoInfo) {
        if( photoInfo != null ){
            if( photoInfo.getPhoto() != null ){
                PhotoInfoPhoto p = photoInfo.getPhoto();
                if( p != null && p.getOwner() != null){
                    userName.set(p.getOwner().getUsername());
                }
                else{
                    userName.set("UserName Not Available");
                }
                if( p != null ){
                    photoUrl.set(Utils.buildUrl(p));
                    title.set(Utils.getTitle(p));
                    subtitle.set(Utils.getSubtitleTitle(p));
                }
            }
        }
        notifyChange();
    }

    @Bindable
    public String getImageUrl() {
        return photoUrl.get();
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.with(view.getContext())
                .load(imageUrl)
                .into(view);
    }

    @Override
    public void onDataNotAvailable() {

    }

    @Override
    public void onDataLoading() {

    }
}
