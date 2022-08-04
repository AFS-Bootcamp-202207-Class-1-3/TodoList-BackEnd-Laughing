package com.example.todolist.exception;

public class TodoItemNotFoundException extends RuntimeException{
    public TodoItemNotFoundException() {
        super("TodoItem not found");
    }
}
