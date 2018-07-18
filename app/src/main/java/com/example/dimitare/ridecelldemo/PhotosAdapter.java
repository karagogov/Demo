package com.example.dimitare.ridecelldemo;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dimitare.ridecelldemo.data.Photo;
import com.example.dimitare.ridecelldemo.databinding.PhotoItemBinding;
import com.example.dimitare.ridecelldemo.utils.CircleTransform;
import com.example.dimitare.ridecelldemo.utils.Utils;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.ViewHolder> {
    public ObservableArrayList<Photo> mPhotos;
    private PhotoItemNavigator mPhotoItemNavigator;

    public PhotosAdapter(PhotoList list, PhotoItemNavigator photoItemNavigator) {
        mPhotos = list.mPhotos;
        mPhotoItemNavigator = photoItemNavigator;
    }

    public void onDestroy() {
        mPhotoItemNavigator = null;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Photo photo = mPhotos.get(position);
        Picasso.with(holder.binder.photo.getContext()).load(Utils.buildUrl(photo))
                .resize(100, 100)
                .centerCrop().transform(new CircleTransform(50, 4)).into(holder.binder.photo, new Callback() {
            @Override
            public void onSuccess() {
                Log.w("Dimitare", "onSuccess");
            }

            @Override
            public void onError() {
                Log.w( "Dimitare", "onError");
            }
        });
        holder.binder.title.setText(photo.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( mPhotoItemNavigator != null ) {
                    Photo photo = (Photo) v.getTag();
                    mPhotoItemNavigator.openPhotoDetails(photo.getId());
                }
            }
        });
        holder.itemView.setTag(photo);
        holder.binder.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return (mPhotos != null ? mPhotos.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        PhotoItemBinding binder;
        public ViewHolder(View v) {
            super(v);
            binder = DataBindingUtil.bind(v);
        }
    }
}
