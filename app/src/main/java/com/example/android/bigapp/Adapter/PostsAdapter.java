package com.example.android.bigapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.AbsSavedState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.bigapp.Interface.OnItemClickedListner;
import com.example.android.bigapp.R;
import com.example.android.bigapp.model.Post;

import java.util.ArrayList;


public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHoler> {
    Context context;
    ArrayList<Post> postArrayList;
    private static final String TAG="BAZZINGA!!!~!";

OnItemClickedListner onItemClickedListner;

    public void setOnItemClickedListner(OnItemClickedListner onItemClickedListner) {
        this.onItemClickedListner = onItemClickedListner;
    }

    public PostsAdapter(Context context, ArrayList<Post> postArrayList) {
        this.context = context;
        this.postArrayList = postArrayList;
        Log.d(TAG, "PostsAdapter: THE ADAPTER WAS CONSTRUCTED");
    }
    public void updatePosts(ArrayList<Post> posts){
        this.postArrayList=posts;
        Log.d(TAG, "updatePosts: THE DOWNLOADED LIST IS SENT TO ADAPTER");
        notifyDataSetChanged();
    }
    @Override
    public PostViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater li=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=li.inflate(R.layout.list_item_post,parent,false);
        Log.d(TAG, "onCreateViewHolder: A VIEW WAS JUST CREATED");
        return new PostViewHoler(v);
    }

    @Override
    public void onBindViewHolder(PostViewHoler holder, int position) {
        Log.d(TAG, "onBindViewHolder: I REACHED ONBINVIEW HOLDER!");
        final Post thisPost=postArrayList.get(position);

        
        holder.userId.setText(String.valueOf(thisPost.getUserId()));
        Log.d(TAG, "onBindViewHolder: BABABABABABABABABABABABABABABABBABA");
        holder.id.setText(String.valueOf(thisPost.getId()));
        holder.title.setText(thisPost.getTitle());
        holder.body.setText(thisPost.getBody());
        Log.d(TAG, "onBindViewHolder: A VIEW WAS JUST BIND");
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickedListner.OnItemClicked(thisPost.getId());



            }
        });

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: COUNT IS GOT");//
        return postArrayList.size();
    }

    class PostViewHoler extends RecyclerView.ViewHolder{

        TextView userId,id,title,body;
        View rootView;
        public PostViewHoler(View itemView) {
            super(itemView);
            userId=(TextView)itemView.findViewById(R.id.userId);
            id=(TextView)itemView.findViewById(R.id.id);
            title=(TextView)itemView.findViewById(R.id.title);
            body=(TextView)itemView.findViewById(R.id.body);
            rootView=itemView;
            Log.d(TAG, "PostViewHoler: ViewHoler RAN SUCESSFULLY");


        }
    }
}

