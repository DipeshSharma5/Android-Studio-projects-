package com.example.android.bigapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.android.bigapp.API.UserAPI;
import com.example.android.bigapp.Adapter.UserAdapter;
import com.example.android.bigapp.Interface.OnItemClickedListner;
import com.example.android.bigapp.Interface.TodoClicked;
import com.example.android.bigapp.R;
import com.example.android.bigapp.model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserActivity extends AppCompatActivity {
    RecyclerView rv;
    UserAdapter userAdapter;
    private static final String TAG="BAZZINGA!!!!!!!!!!!!";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Log.d(TAG, "onCreate: I AM IN USER ACTIVITY");
        rv=(RecyclerView)findViewById(R.id.rv);
        userAdapter =new UserAdapter(this,new ArrayList<User>());//PASSED EMPTY LIST
        Log.d(TAG, "onCreate-BACK to UserActivity: ");
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(userAdapter);


userAdapter.setOnItemClickedListner(new OnItemClickedListner() {
    @Override
    public void OnItemClicked(int itemId) {
        Log.d(TAG, "OnItemClicked: "+itemId);
        //show posts specific to users id-
        Intent i=new Intent(UserActivity.this,PostsActivity.class);
        i.putExtra("userId",itemId);
        startActivity(i);
    }
});
       userAdapter.setTodoClicked(new TodoClicked() {
           @Override
           public void sendUserID(int userId) {
               Log.d(TAG, "sendUserID: SENT THE USER ID TO TO-DO ACTIVITY");
               Intent i=new Intent(UserActivity.this,ToDoActivity.class);
               i.putExtra("userId",userId);
               startActivity(i);

           }
       });




        Retrofit retrofitInstance= new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //now make api
        Log.d(TAG, "onCreate-RETROFIT Instance is OK: ");
        UserAPI userAPI=retrofitInstance.create(UserAPI.class);
        Log.d(TAG, "onCreate: User api is functional");

        userAPI.downloadUserList().enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call,
                                   Response<ArrayList<User>> response) {
                userAdapter.updateUsers(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {

            }
        });











     /* ArrayList<User> testListforAdapter=new ArrayList<User>();
        testListforAdapter.add(new User(1,"SDFDSF","ASDFSD","ADSFDS","ADSFDSF"));
        testListforAdapter.add(new User(1,"SDFDSF","ASDFSD","ADSFDS","ADSFDSF"));
        testListforAdapter.add(new User(1,"SDFDSF","ASDFSD","ADSFDS","ADSFDSF"));
        testListforAdapter.add(new User(1,"SDFDSF","ASDFSD","ADSFDS","ADSFDSF"));
        testListforAdapter.add(new User(1,"SDFDSF","ASDFSD","ADSFDS","ADSFDSF"));
        testListforAdapter.add(new User(1,"SDFDSF","ASDFSD","ADSFDS","ADSFDSF"));
        testListforAdapter.add(new User(1,"SDFDSF","ASDFSD","ADSFDS","ADSFDSF"));
        testListforAdapter.add(new User(1,"SDFDSF","ASDFSD","ADSFDS","ADSFDSF"));
        testListforAdapter.add(new User(1,"SDFDSF","ASDFSD","ADSFDS","ADSFDSF"));
        testListforAdapter.add(new User(1,"SDFDSF","ASDFSD","ADSFDS","ADSFDSF"));
        testListforAdapter.add(new User(1,"SDFDSF","ASDFSD","ADSFDS","ADSFDSF"));
        testListforAdapter.add(new User(1,"SDFDSF","ASDFSD","ADSFDS","ADSFDSF"));
        testListforAdapter.add(new User(1,"SDFDSF","ASDFSD","ADSFDS","ADSFDSF"));

        userAdapter.updateUsers(testListforAdapter);

        WORKING SUCESSFULLY!!!
        */










    }
}
