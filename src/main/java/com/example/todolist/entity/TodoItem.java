package com.example.todolist.entity;

import javax.persistence.*;

@Entity
@Table(name = "todo")
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private Boolean done;

    public TodoItem() {
    }

    public TodoItem(int id, String text, Boolean done) {
        this.id = id;
        this.text = text;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public void merge(TodoItem newItem){
        if(newItem.getDone()!=null){
            this.done=newItem.getDone();
        }
        if(newItem.getText()!=null) {
            this.text = newItem.getText();
        }
    }

    public Boolean getDone() {
        return done;
    }
}
