package com.example.todoio;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Todo_Adapter extends RecyclerView.Adapter<Todo_Adapter.ViewHolder>  {

    Context context;
    ArrayList<Todo> todoArray = new ArrayList<>();

    public Todo_Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Todo_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.todo, parent, false);

        return new Todo_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Todo_Adapter.ViewHolder holder, int position) {
        holder.text.setText(todoArray.get(position).getTodoText());
        holder.cbIsDone.setChecked(todoArray.get(position).isDone);

        holder.cbIsDone.setOnCheckedChangeListener((compoundButton, b) -> {
            compoundButton.setChecked(b);
            if(b) {
                holder.text.setPaintFlags(holder.text.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            }else {
                holder.text.setPaintFlags(0);
            }

        });
    }

    @Override
    public int getItemCount() {
        return todoArray.size();
    }

    public void addTodo(String text) {
        Todo newTodo = new Todo(text, false);
        todoArray.add(0, newTodo);
        notifyItemInserted(0);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView text;
        CheckBox cbIsDone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.todoText);
            cbIsDone = itemView.findViewById(R.id.todoDone);
        }
    }
}
