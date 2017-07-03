package com.example.android.bigapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.bigapp.API.CommentsAPI;
import com.example.android.bigapp.Adapter.CommentsAdapter;
import com.example.android.bigapp.R;
import com.example.android.bigapp.model.Comment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CommentsActivity extends AppCompatActivity {
int postIdRecieved;
    RecyclerView rv;
    CommentsAdapter commentsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        Intent i=getIntent();
        postIdRecieved=i.getIntExtra("post_id",-1);
        rv=(RecyclerView)findViewById(R.id.comments_recyclerView);
        commentsAdapter=new CommentsAdapter(new ArrayList<Comment>(),this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(commentsAdapter);

        Retrofit retrofitInstance=new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CommentsAPI api=retrofitInstance.create(CommentsAPI.class);

       /* api.getAllcomments().enqueue(new Callback<ArrayList<Comment>>() {
            @Override
            public void onResponse(Call<ArrayList<Comment>> call, Response<ArrayList<Comment>> response) {
                commentsAdapter.updateCommentsList(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Comment>> call, Throwable t) {

            }
        });*/
api.getCommentsByPostId(postIdRecieved).enqueue(new Callback<ArrayList<Comment>>() {
    @Override
    public void onResponse(Call<ArrayList<Comment>> call, Response<ArrayList<Comment>> response) {
        commentsAdapter.updateCommentsList(response.body());
    }

    @Override
    public void onFailure(Call<ArrayList<Comment>> call, Throwable t) {

    }
});

    }
}
