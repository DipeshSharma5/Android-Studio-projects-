package com.example.android.bigapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.bigapp.Interface.OnItemClickedListner;
import com.example.android.bigapp.R;
import com.example.android.bigapp.model.Album;

import java.util.ArrayList;

/**
 * Created by Chetan on 6/30/2017.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    ArrayList<Album> albums;
    Context context;


    public AlbumAdapter(ArrayList<Album> albums, Context context) {
        this.albums = albums;
        this.context = context;
    }

    OnItemClickedListner onItemClickedListner;

    public void setOnItemClickedListner(OnItemClickedListner onItemClickedListner) {
        this.onItemClickedListner = onItemClickedListner;
    }

    public void updateAlbumsList(ArrayList<Album> albums){
        this.albums=albums;
        notifyDataSetChanged();

    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=li.inflate(R.layout.list_item_album,parent,false);

        return new AlbumViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder holder, int position) {
        final Album thisAlbum=albums.get(position);
        holder.userId.setText(String.valueOf(thisAlbum.getUserId()));
        holder.id.setText(String.valueOf(thisAlbum.getId()));
        holder.title.setText(thisAlbum.getTitle());
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickedListner.OnItemClicked(thisAlbum.getUserId());
            }
        });

    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    class AlbumViewHolder extends RecyclerView.ViewHolder{
TextView userId,id,title;
        View rootView;

        public AlbumViewHolder(View itemView) {
            super(itemView);
            userId=(TextView)itemView.findViewById(R.id.userId);
            id=(TextView)itemView.findViewById(R.id.id);
            title=(TextView)itemView.findViewById(R.id.title);
            rootView=itemView;

        }
    }
}
