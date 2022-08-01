package com.example.todoio;

public class Todo {
    String todoText;
    Boolean isDone;

    public Todo(String todoText, Boolean isDone) {
        this.todoText = todoText;
        this.isDone = isDone;
    }

    public String getTodoText() {
        return todoText;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public void setTodoText(String todoText) {
        this.todoText = todoText;
    }
}
