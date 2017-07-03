package com.example.android.bigapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.android.bigapp.API.ThumbnailsAPI;
import com.example.android.bigapp.Adapter.ThumbnalisAdapter;
import com.example.android.bigapp.R;
import com.example.android.bigapp.model.Thumbnail;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ThumbnalisActivity extends AppCompatActivity {
int albumIdRecieved;
    RecyclerView rv;
    ThumbnalisAdapter thumbnalisAdapter;
    private static String TAG="BAZZIZZIZZINGAA!!";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thumbnalis);
        Intent i=getIntent();
        albumIdRecieved=i.getIntExtra("albumId",-1);
        Log.d(TAG, "onCreate: ALBUM ID RECIEVED");
        rv=(RecyclerView)findViewById(R.id.rv);
        rv.setLayoutManager(new GridLayoutManager(this,3));
        thumbnalisAdapter=new ThumbnalisAdapter
                (new ArrayList< Thumbnail>(),this);
        rv.setAdapter(thumbnalisAdapter);
        thumbnalisAdapter.setOnThumbnailClickListner(new ThumbnalisAdapter.OnThumbnailClickListner() {
            @Override
            public void onThumbnailClicked(String imageUrl, String title,int albumId) {
                //SEND TO DISPLAY THE FULL IMAGE AND TITLE
                Intent i=new Intent(ThumbnalisActivity.this,PhotoActivity.class);
                i.putExtra("title",title);
                i.putExtra("imageUrl",imageUrl);
                i.putExtra("albumId",albumId);
                startActivity(i);

            }
        });


        Retrofit retrofitInstance =new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ThumbnailsAPI thumbnailsAPI=retrofitInstance.create(ThumbnailsAPI.class);

thumbnailsAPI.getThumbnailsByAlbumId(albumIdRecieved).enqueue(new Callback<ArrayList<Thumbnail>>() {
    @Override
    public void onResponse(Call<ArrayList<Thumbnail>> call, Response<ArrayList<Thumbnail>> response) {
        Log.d(TAG, "onResponse: THE THUBNAILS ARE READY TO BE PINNED");
        thumbnalisAdapter.updateThumnailsList(response.body());
    }

    @Override
    public void onFailure(Call<ArrayList<Thumbnail>> call, Throwable t) {

    }
});










    }
}
