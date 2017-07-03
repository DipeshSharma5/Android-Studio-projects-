package com.example.android.bigapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.android.bigapp.API.PostsAPI;
import com.example.android.bigapp.Adapter.PostsAdapter;
import com.example.android.bigapp.Interface.OnItemClickedListner;
import com.example.android.bigapp.R;
import com.example.android.bigapp.model.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsActivity extends AppCompatActivity {
private static final String TAG="BAZZINGA!!!!!";
    RecyclerView rv;
    PostsAdapter postsAdapter;
    int userIdRecieved;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        Intent i=getIntent();
        userIdRecieved=i.getIntExtra("userId",-1);

        Log.d(TAG, "onCreate: I AMA IN POSTS ACTIVITY");//
        rv=(RecyclerView)findViewById(R.id.posts_recyclerView);
        postsAdapter=new PostsAdapter(this,new ArrayList<Post>());
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(postsAdapter);
        postsAdapter.setOnItemClickedListner(new OnItemClickedListner() {
            @Override
            public void OnItemClicked(int itemId) {
                Intent i=new Intent(PostsActivity.this,CommentsActivity.class);
            i.putExtra("post_id",itemId);
                startActivity(i);

            }
        });


        Retrofit retrofitInstance=new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostsAPI postApi=retrofitInstance.create(PostsAPI.class);


        Callback<ArrayList<Post>> callback=new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                postsAdapter.updatePosts(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

            }
        };


        if(userIdRecieved==-1)
        postApi.getAllPosts().enqueue(callback);
        else
            postApi.getPostsByUserId(userIdRecieved).enqueue(callback);
















/*
ArrayList<Post> testLIst=new ArrayList<>();
        testLIst.add(new Post(1,1,"ADF","ASF"));
        testLIst.add(new Post(1,1,"ADF","ASF"));
        testLIst.add(new Post(1,1,"ADF","ASF"));
        testLIst.add(new Post(1,1,"ADF","ASF"));
        testLIst.add(new Post(1,1,"ADF","ASF"));
        testLIst.add(new Post(1,1,"ADF","ASF"));
        testLIst.add(new Post(1,1,"ADF","ASF"));
        testLIst.add(new Post(1,1,"ADF","ASF"));
        testLIst.add(new Post(1,1,"ADF","ASF"));
        testLIst.add(new Post(1,1,"ADF","ASF"));
        testLIst.add(new Post(1,1,"ADF","ASF"));
        testLIst.add(new Post(1,1,"ADF","ASF"));
        testLIst.add(new Post(1,1,"ADF","ASF"));
        testLIst.add(new Post(1,1,"ADF","ASF"));
        testLIst.add(new Post(1,1,"ADF","ASF"));
        testLIst.add(new Post(1,1,"ADF","ASF"));
        testLIst.add(new Post(1,1,"ADF","ASF"));
        testLIst.add(new Post(1,1,"ADF","ASF"));
        testLIst.add(new Post(1,1,"ADF","ASF"));
        testLIst.add(new Post(1,1,"ADF","ASF"));

        postsAdapter.updatePosts(testLIst);
*/


        
        
        
        
        
        
        
        
    }
    
    
}
