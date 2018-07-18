package com.example.dimitare.ridecelldemo.utils;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.dimitare.ridecelldemo.ViewModelHolder;

import static android.support.v4.util.Preconditions.checkNotNull;

public class ActivityUtils {
    @SuppressLint("RestrictedApi")
    public static void addFragmentToActivity (@NonNull FragmentManager fragmentManager,
                                              @NonNull ViewModelHolder fragment, String frameId) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(fragment, frameId);
        transaction.commit();
    }

    @SuppressLint("RestrictedApi")
    public static void addFragmentToActivity (@NonNull FragmentManager fragmentManager,
                                              @NonNull Fragment fragment, int frameId) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }
}
