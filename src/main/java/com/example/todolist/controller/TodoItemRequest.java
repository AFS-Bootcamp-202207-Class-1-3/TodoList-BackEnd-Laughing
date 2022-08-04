package com.example.todolist.controller;

public class TodoItemRequest {
    private String text;
    private boolean done=false;

    public TodoItemRequest() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
