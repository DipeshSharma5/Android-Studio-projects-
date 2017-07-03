package com.example.android.bigapp.Activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.bigapp.API.PhotoAPI;
import com.example.android.bigapp.Adapter.PhotosAdapter;
import com.example.android.bigapp.EachPhotosFragment;
import com.example.android.bigapp.R;
import com.example.android.bigapp.model.Photo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PhotoActivity extends AppCompatActivity {
   private static String TAG="BAZZZZZINGAAAA!!!!!!";
    String title,imageUrl;
    PhotosAdapter photosAdapter;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        Intent i=getIntent();
         title=i.getStringExtra("title");
        imageUrl=i.getStringExtra("imageUrl");
        int albumId=i.getIntExtra("albumId",-1);
        Log.d(TAG, "onCreate: I AM IN PHOTOS ACTIVITY");
      
        
        viewPager=(ViewPager)findViewById(R.id.viewpager);


        Retrofit retrofitInstance=new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PhotoAPI photoAPI=retrofitInstance.create(PhotoAPI.class);

        photoAPI.getAllPhotosofAlbum(albumId).enqueue(new Callback<ArrayList<Photo>>() {
            @Override
            public void onResponse(Call<ArrayList<Photo>> call, Response<ArrayList<Photo>> response) {
                Log.d(TAG, "onResponse: THE DOWNLOADED PHOTOLIST IS HERE");




                photosAdapter=new PhotosAdapter
                        (getSupportFragmentManager(),
                                photoListtoFragmentList(response.body()),
                                response.body().size());
                viewPager.setAdapter(photosAdapter);










               /* photosAdapter.updateFragmentsList
                        (photoListtoFragmentList(response.body()));*/
            }

            @Override
            public void onFailure(Call<ArrayList<Photo>> call, Throwable t) {

            }
        });



    }
    public ArrayList<Fragment>photoListtoFragmentList(ArrayList<Photo> photos){
        ArrayList<Fragment> fragmentArrayList=new ArrayList<Fragment>();

        for(Photo p:photos){
            fragmentArrayList.add
                    (EachPhotosFragment.newInstance(p.getUrl(),p.getTitle()));

        }
        fragmentArrayList.add(0,EachPhotosFragment.newInstance(imageUrl,title));
return fragmentArrayList;
    }
}
