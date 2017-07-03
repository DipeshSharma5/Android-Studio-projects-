package com.example.android.bigapp.API;

import com.example.android.bigapp.model.Thumbnail;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Chetan on 6/30/2017.
 */

public interface ThumbnailsAPI {
@GET("/albums/{albumId}/photos")
    Call<ArrayList<Thumbnail>>getThumbnailsByAlbumId(@Path("albumId")int albumId);
}
