package com.example.android.bigapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.android.bigapp.API.TodosAPI;
import com.example.android.bigapp.Adapter.ToDosAdapter;
import com.example.android.bigapp.R;
import com.example.android.bigapp.model.ToDo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ToDoActivity extends AppCompatActivity {
RecyclerView rv;
    ToDosAdapter toDosAdapter;
    int userIDrecieved;
    private static  String TAG="BAZZZINGAAAAA!!!!!!";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);
        rv=(RecyclerView)findViewById(R.id.rv);
        toDosAdapter=new ToDosAdapter(new ArrayList<ToDo>(),this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(toDosAdapter);
        Intent i=getIntent();
        userIDrecieved=i.getIntExtra("userId",-1);
        Log.d(TAG, "onCreate: BRO I RECIEVED THE ID");


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TodosAPI todosAPI=retrofit.create(TodosAPI.class);



        Callback<ArrayList<ToDo>> callback=new Callback<ArrayList<ToDo>>() {
            @Override
            public void onResponse(Call<ArrayList<ToDo>> call, Response<ArrayList<ToDo>> response) {
                toDosAdapter.updatTodoList(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<ToDo>> call, Throwable t) {

            }
        };





        if(userIDrecieved==-1)
        todosAPI.getThetodoList().enqueue(callback);
        else
            todosAPI.getTodosByUserId(userIDrecieved).enqueue(callback);

















    }
}
