package com.example.android.bigapp.API;

import com.example.android.bigapp.model.Comment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;



public interface CommentsAPI {
    @GET("/comments")
    Call<ArrayList<Comment>>getCommentsByPostId(@Query("postId") int postId);
    @GET("/comments")
    Call<ArrayList<Comment>>getAllcomments();

}
