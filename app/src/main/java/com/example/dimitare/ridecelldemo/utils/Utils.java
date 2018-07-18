package com.example.dimitare.ridecelldemo.utils;

import com.example.dimitare.ridecelldemo.data.Description;
import com.example.dimitare.ridecelldemo.data.Photo;
import com.example.dimitare.ridecelldemo.data.PhotoInfoPhoto;
import com.example.dimitare.ridecelldemo.data.Title;

public class Utils {
    public static String buildUrl(Photo photo) {
        StringBuilder sb = new StringBuilder();
        sb.append("https://farm");
        sb.append(photo.getFarm());
        sb.append(".staticflickr.com/");
        sb.append(photo.getServer());
        sb.append("/");
        sb.append(photo.getId() + "_" + photo.getSecret());
        sb.append(".jpg");
        return sb.toString();
    }

    public static String buildUrl(PhotoInfoPhoto photo) {
        StringBuilder sb = new StringBuilder();
        sb.append("https://farm");
        sb.append(photo.getFarm());
        sb.append(".staticflickr.com/");
        sb.append(photo.getServer());
        sb.append("/");
        sb.append(photo.getId() + "_" + photo.getSecret());
        sb.append(".jpg");
        return sb.toString();
    }

    public static String getTitle(PhotoInfoPhoto p) {
        Title t = p.getTitle();
        if( t != null && t.getContent() != null ){
            return t.getContent();
        }
        return null;
    }

    public static String getSubtitleTitle(PhotoInfoPhoto p) {
        Description description = p.getDescription();
        if( description != null && description.getContent() != null ){
            return description.getContent();
        }
        return null;
    }
}
