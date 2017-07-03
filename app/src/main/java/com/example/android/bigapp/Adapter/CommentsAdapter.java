package com.example.android.bigapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.bigapp.R;
import com.example.android.bigapp.model.Comment;

import java.util.ArrayList;

/**
 * Created by Chetan on 6/30/2017.
 */

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder> {
    ArrayList<Comment> comments;
    Context context;

    public CommentsAdapter(ArrayList<Comment> comments, Context context) {
        this.comments = comments;
        this.context = context;
    }
    public void updateCommentsList(ArrayList<Comment> comments){
        this.comments=comments;
        notifyDataSetChanged();
    }

    @Override
    public CommentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=li.inflate(R.layout.list_item_comments,parent,false);
        return new CommentsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CommentsViewHolder holder, int position) {
Comment thisComment=comments.get(position);
        holder.postId.setText(String.valueOf(thisComment.getPostId()));
        holder.id.setText(String.valueOf(thisComment.getId()));
        holder.name.setText(thisComment.getName());
        holder.email.setText(thisComment.getEmail());
        holder.body.setText(thisComment.getBody());

    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    class CommentsViewHolder extends RecyclerView.ViewHolder{
        TextView postId,id,name,email,body;
        View rootView;

        public CommentsViewHolder(View itemView) {
            super(itemView);
            postId=(TextView)itemView.findViewById(R.id.postId);
            id=(TextView)itemView.findViewById(R.id.id);
            name=(TextView)itemView.findViewById(R.id.name);
            email=(TextView)itemView.findViewById(R.id.email);
            body=(TextView)itemView.findViewById(R.id.body);
            rootView=itemView;



        }
    }
}
