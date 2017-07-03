package com.example.android.bigapp.model;

/**
 * Created by Chetan on 7/1/2017.
 */

public class Photo {
    String url;
    String title;

    public Photo(String imageUrl, String title) {
        this.url = imageUrl;
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
