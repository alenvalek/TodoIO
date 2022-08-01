package com.example.todoio;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todoio.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // init layout
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        RecyclerView recyclerView = findViewById(R.id.rvTodos);

        Todo_Adapter todoAdapter = new Todo_Adapter(this);
        recyclerView.setAdapter(todoAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        binding.btnAddTodo.setOnClickListener(view -> {
            String newTodoText = binding.editNewTodo.getText().toString();
            if(newTodoText.length() < 3) {
                Toast.makeText(getApplicationContext(), "Your todo is too short!", Toast.LENGTH_LONG).show();
                return;
            }
            todoAdapter.addTodo(newTodoText);
            binding.editNewTodo.setText("");
            Toast.makeText(getApplicationContext(), "New Todo added!", Toast.LENGTH_LONG).show();
        });
    }
}