package com.example.dimitare.ridecelldemo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements PhotoItemNavigator {
    public static final String PHOTO_VIEWMODEL_TAG = "photo_viewmodel";
    SearchRepository mPhotoRepository;
    private PhotoViewModel mSearchViewModel;
    SearchFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPhotoRepository = new SearchRepository();
        mSearchViewModel = findOrCreateMediaViewModel();
        mFragment = (SearchFragment) getSupportFragmentManager().findFragmentById(R.id.search_fragment);
        mFragment.setViewModel(mSearchViewModel);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //https://www.javatpoint.com/android-searchview-on-toolbar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem searchViewItem = menu.findItem(R.id.app_bar_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                if( query.length() > 2 && mFragment != null ){
                    mFragment.findFlikrPhotos(query);
                    return true;
                }
                return false;

            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @NonNull
    private PhotoViewModel findOrCreateMediaViewModel() {
        @SuppressWarnings("unchecked")
        ViewModelHolder<PhotoViewModel> retainedViewModel =
                (ViewModelHolder<PhotoViewModel>) getSupportFragmentManager()
                        .findFragmentByTag(PHOTO_VIEWMODEL_TAG);

        if (retainedViewModel != null && retainedViewModel.getViewmodel() != null) {
            return retainedViewModel.getViewmodel();
        } else {
            PhotoViewModel viewModel = new PhotoViewModel(
                    mPhotoRepository);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.container, ViewModelHolder.createContainer(viewModel),
                    PHOTO_VIEWMODEL_TAG);
            transaction.commit();
            return viewModel;
        }
    }

    @Override
    public void openPhotoDetails(final String photoId) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, PhotoDetailActivity.class);
                intent.putExtra(PhotoDetailActivity.EXTRA_PHOTO_ID, photoId);
                startActivityForResult(intent, PhotoDetailActivity.REQUEST_CODE);
            }
        });
    }
}
