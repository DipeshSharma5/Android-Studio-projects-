package com.example.android.bigapp.API;


import com.example.android.bigapp.model.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PostsAPI {
    @GET("/posts")
    Call<ArrayList<Post>>getAllPosts();

    @GET("/posts")
    Call<ArrayList<Post>>getPostsByUserId(@Query("userId")int userId);
}
