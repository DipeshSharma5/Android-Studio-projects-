package com.example.android.bigapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.bigapp.Interface.OnItemClickedListner;
import com.example.android.bigapp.R;
import com.example.android.bigapp.model.Thumbnail;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Chetan on 6/30/2017.
 */

public class ThumbnalisAdapter extends RecyclerView.Adapter<ThumbnalisAdapter.ThumbnaliViewHolder> {
    private static String TAG="BAZZIZZIZZINGAA!!";
ArrayList<Thumbnail> thumbnails;
    Context context;

    public ThumbnalisAdapter(ArrayList<Thumbnail> thumbnails, Context context) {
        this.thumbnails = thumbnails;
        this.context = context;
        Log.d(TAG, "ThumbnalisAdapter: ");
    }
public void updateThumnailsList(ArrayList<Thumbnail> thumbnails)
{
    Log.d(TAG, "updateThumnailsList: DOWNLOADED THUMBNAILS ARE WITH ADAPTER");
    this.thumbnails=thumbnails;
    notifyDataSetChanged();
}
public interface OnThumbnailClickListner{
    void onThumbnailClicked(String imageUrl,String title,int albumId);
}
OnThumbnailClickListner onThumbnailClickListner;

    public void setOnThumbnailClickListner(OnThumbnailClickListner onThumbnailClickListner) {
        this.onThumbnailClickListner = onThumbnailClickListner;
    }

    @Override
    public ThumbnaliViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Log.d(TAG, "onCreateViewHolder: ");
        View v=li.inflate(R.layout.list_item_thumbnail,parent,false);
        return new ThumbnaliViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ThumbnaliViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: BIND KARNE AYA HAI");//
        final Thumbnail thisThumbnail=thumbnails.get(position);
        holder.albumId.setText(String.valueOf(thisThumbnail.getAlbumId()));
        holder.id.setText(String.valueOf(thisThumbnail.getId()));
        holder.title.setText(thisThumbnail.getTitle());
        Picasso.with(context).load(thisThumbnail.getThumbnailUrl()).into(holder.imageView);
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onThumbnailClickListner.
                        onThumbnailClicked
                        (thisThumbnail.getUrl(),thisThumbnail.getTitle(),thisThumbnail.getAlbumId());

            }
        });


    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: ");
        return thumbnails.size();
    }

    class ThumbnaliViewHolder extends RecyclerView.ViewHolder{
        TextView albumId,id,title;
        ImageView imageView;
        View rootView;
        public ThumbnaliViewHolder(View itemView) {
            super(itemView);
            albumId=(TextView)itemView.findViewById(R.id.albumId);
            id=(TextView)itemView.findViewById(R.id.id);
            title=(TextView)itemView.findViewById(R.id.title);
            imageView=(ImageView)itemView.findViewById(R.id.ima);
            rootView=itemView;
            //view holder doesno only holda views for us it also holds data for us
        }
    }
}
