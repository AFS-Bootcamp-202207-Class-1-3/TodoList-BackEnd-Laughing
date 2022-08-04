package com.example.todolist.controller;

import com.example.todolist.entity.TodoItem;
import com.example.todolist.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping
public class TodoListController {

    @Autowired
    private TodoListService todoListService;

    @GetMapping("/Todos")
    public List<TodoItem> getAllItems(){
        return todoListService.getAllItems();
    }
}
