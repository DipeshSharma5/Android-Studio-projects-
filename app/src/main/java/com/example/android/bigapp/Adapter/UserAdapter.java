package com.example.android.bigapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.bigapp.Activities.ToDoActivity;
import com.example.android.bigapp.Interface.OnItemClickedListner;
import com.example.android.bigapp.Interface.TodoClicked;
import com.example.android.bigapp.R;
import com.example.android.bigapp.model.User;

import java.util.ArrayList;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>  {
    private Context context;
    private ArrayList<User> users;
    private static final String TAG="BAZZINGA!!!!!!!!!!!!";

    public UserAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
        Log.d(TAG, "UserAdapter: ");
    }
    OnItemClickedListner onItemClickedListner;
    private TodoClicked todoClicked;

    public void setTodoClicked(TodoClicked todoClicked) {
        this.todoClicked = todoClicked;
    }

    public void setOnItemClickedListner(OnItemClickedListner onItemClickedListner) {
        this.onItemClickedListner = onItemClickedListner;
    }

    public void updateUsers(ArrayList<User> userArrayList){
        this.users=userArrayList;
        notifyDataSetChanged();
    }



    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li=(LayoutInflater)context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        Log.d(TAG, "onCreateViewHolder1: ");
        View itemView=li.inflate(R.layout.list_item_user,parent,false);
        Log.d(TAG, "onCreateViewHolder: ");
        return new UserViewHolder(itemView);
        
    }


    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        final User thisUser=users.get(position);
        holder.user_name.setText(thisUser.getUsername());
        holder.name.setText(thisUser.getName());
        holder.phone.setText(thisUser.getPhone());
        holder.email.setText(thisUser.getEmail());
        holder.posts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickedListner.OnItemClicked(thisUser.getId());

            }
        });
        holder.todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                todoClicked.sendUserID(thisUser.getId());
            }
        });

        Log.d(TAG, "onBindViewHolder: ");
    }


    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: ");
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{
        TextView user_name,name,phone,email;
        Button posts,todo;
        View rootView;
        private UserViewHolder(View itemView) {
            super(itemView);
            user_name=(TextView)itemView.findViewById(R.id.tvUserUsername);
            name=(TextView)itemView.findViewById(R.id.tvUserName);
            phone=(TextView)itemView.findViewById(R.id.tvUserPhone);
            email=(TextView)itemView.findViewById(R.id.tvUserEmail);
            posts=(Button) itemView.findViewById(R.id.post_trigger);
            todo=(Button)itemView.findViewById(R.id.todo_trigger);
            rootView=itemView;
            Log.d(TAG, "UserViewHolder: ");

        }
    }
}
