package com.example.android.bigapp.API;

import com.example.android.bigapp.model.Album;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Chetan on 6/30/2017.
 */

public interface AlbumsAPI {
    @GET("/albums")
    Call<ArrayList<Album>>getAlbums();
}
