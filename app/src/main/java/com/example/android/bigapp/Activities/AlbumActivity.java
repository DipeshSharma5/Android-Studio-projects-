package com.example.android.bigapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.android.bigapp.API.AlbumsAPI;
import com.example.android.bigapp.Adapter.AlbumAdapter;
import com.example.android.bigapp.Interface.OnItemClickedListner;
import com.example.android.bigapp.R;
import com.example.android.bigapp.model.Album;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AlbumActivity extends AppCompatActivity {
    RecyclerView rv;
    AlbumAdapter albumAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        rv=(RecyclerView)findViewById(R.id.rv);
        albumAdapter=new AlbumAdapter(new ArrayList<Album>(),this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(albumAdapter);
        albumAdapter.setOnItemClickedListner(new OnItemClickedListner() {
            @Override
            public void OnItemClicked(int itemId) {
               Intent i=new Intent(AlbumActivity.this,ThumbnalisActivity.class);
                i.putExtra("albumId",itemId);
                startActivity(i);

            }
        });


        Retrofit retrofitInstance=new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AlbumsAPI albumsAPI=retrofitInstance.create(AlbumsAPI.class);
        albumsAPI.getAlbums().enqueue(new Callback<ArrayList<Album>>() {
            @Override
            public void onResponse(Call<ArrayList<Album>> call, Response<ArrayList<Album>> response) {
                albumAdapter.updateAlbumsList(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Album>> call, Throwable t) {

            }
        });

    }
}
