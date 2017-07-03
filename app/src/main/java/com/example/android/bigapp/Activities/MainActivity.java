package com.example.android.bigapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.bigapp.R;

public class MainActivity extends AppCompatActivity {
Button users,posts,albums,to_dos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        users=(Button)findViewById(R.id.users);
        posts=(Button)findViewById(R.id.posts);
        albums=(Button)findViewById(R.id.albums);
        to_dos=(Button)findViewById(R.id.to_do);

        users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,UserActivity.class);
                startActivity(i);
            }
        });


        posts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,PostsActivity.class);
                startActivity(i);
            }
        });
        albums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,AlbumActivity.class);
                startActivity(i);
            }
        });
        to_dos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,ToDoActivity.class);
                startActivity(i);

            }
        });

    }
}
