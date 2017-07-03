package com.example.android.bigapp.API;

import com.example.android.bigapp.model.ToDo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Chetan on 7/1/2017.
 */
//fyi {} is a placeHolder for what you give in path
public interface TodosAPI {
    @GET("/todos")
    Call<ArrayList<ToDo>>getThetodoList();

    @GET("/todos")
    Call<ArrayList<ToDo>>getTodosByUserId(@Query("userId") int userId);

}
