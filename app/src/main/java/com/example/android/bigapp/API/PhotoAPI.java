package com.example.android.bigapp.API;

import com.example.android.bigapp.model.Photo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Chetan on 7/1/2017.
 */

public interface PhotoAPI {
    @GET("/albums/{albumId}/photos")
    Call<ArrayList<Photo>>getAllPhotosofAlbum(@Path("albumId")int albumId);
}
