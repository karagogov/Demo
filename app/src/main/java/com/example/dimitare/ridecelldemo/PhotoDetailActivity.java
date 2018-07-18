package com.example.dimitare.ridecelldemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.example.dimitare.ridecelldemo.utils.ActivityUtils;

public class PhotoDetailActivity extends AppCompatActivity {
    public static String EXTRA_PHOTO_ID = "PHOTO_ID";
    public static final int REQUEST_CODE = 1;
    public static final String PHOTODETAIL_VIEWMODEL_TAG = "PHOTODETAIL_VIEWMODEL_TAG";

    //have to inject this as singleton
    SearchRepository mPhotoRepository;
    private PhotoDetailViewModel photoDetailViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_detail_layout);
        mPhotoRepository = new SearchRepository();


        PhotoDetailFragment photoDetailFragment = findOrCreateViewFragment();

        photoDetailViewModel = findOrCreateViewModel();
        photoDetailFragment.setViewModel(photoDetailViewModel);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            setResult(RESULT_OK);
            finish();
        }
    }

    @NonNull
    private PhotoDetailViewModel findOrCreateViewModel() {
        // In a configuration change we might have a ViewModel present. It's retained using the
        // Fragment Manager.
        @SuppressWarnings("unchecked")
        ViewModelHolder<PhotoDetailViewModel> retainedViewModel =
                (ViewModelHolder<PhotoDetailViewModel>) getSupportFragmentManager()
                        .findFragmentByTag(PHOTODETAIL_VIEWMODEL_TAG);

        if (retainedViewModel != null && retainedViewModel.getViewmodel() != null) {
            // If the model was retained, return it.
            return retainedViewModel.getViewmodel();
        } else {
            // There is no ViewModel yet, create it.
            PhotoDetailViewModel viewModel = new PhotoDetailViewModel(mPhotoRepository);

            // and bind it to this Activity's lifecycle using the Fragment Manager.
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(),
                    ViewModelHolder.createContainer(viewModel),
                    PHOTODETAIL_VIEWMODEL_TAG);
            return viewModel;
        }
    }

    @NonNull
    private PhotoDetailFragment findOrCreateViewFragment() {
        String photoId = getIntent().getStringExtra(EXTRA_PHOTO_ID);

        PhotoDetailFragment taskDetailFragment = (PhotoDetailFragment) getSupportFragmentManager()
                .findFragmentById(R.id.photo_details_fragment);

        if (taskDetailFragment == null) {
            taskDetailFragment = PhotoDetailFragment.newInstance(photoId);

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    taskDetailFragment, R.id.contentFrame);
        }
        else{
            taskDetailFragment.setPhotoId(photoId);
        }
        return taskDetailFragment;
    }
}
