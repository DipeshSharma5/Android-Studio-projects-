package com.example.android.bigapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.android.bigapp.R;
import com.example.android.bigapp.model.ToDo;

import java.util.ArrayList;

/**
 * Created by Chetan on 7/1/2017.
 */

public class ToDosAdapter extends RecyclerView.Adapter<ToDosAdapter.ToDoViewHolder> {

    ArrayList<ToDo> toDos;
    Context context;

    public ToDosAdapter(ArrayList<ToDo> toDos, Context context) {
        this.toDos = toDos;
        this.context = context;
    }
    public void updatTodoList(ArrayList<ToDo> toDos){
        this.toDos=toDos;
        notifyDataSetChanged();
    }

    @Override
    public ToDoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater li=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=li.inflate(R.layout.list_item_todo,parent,false);
        return new ToDoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ToDoViewHolder holder, int position) {
        ToDo thisTodo=toDos.get(position);
        holder.tv.setText(thisTodo.getTitle());
        holder.checkBox.setChecked(thisTodo.getCompleted());

    }

    @Override
    public int getItemCount() {
        return toDos.size();
    }

    class ToDoViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        CheckBox checkBox;
        public ToDoViewHolder(View itemView) {
            super(itemView);
            tv=(TextView)itemView.findViewById(R.id.tv);
            checkBox=(CheckBox)itemView.findViewById(R.id.checkbox);
        }
    }
}
