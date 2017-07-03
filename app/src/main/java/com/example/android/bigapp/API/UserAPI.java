package com.example.android.bigapp.API;


import com.example.android.bigapp.model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserAPI {
    @GET("/users")
    Call<ArrayList<User>> downloadUserList();

}
