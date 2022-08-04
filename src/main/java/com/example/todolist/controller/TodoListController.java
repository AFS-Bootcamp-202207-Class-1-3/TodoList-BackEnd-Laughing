package com.example.todolist.controller;

import com.example.todolist.entity.TodoItem;
import com.example.todolist.service.TodoListService;
import mapper.TodoItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Todos")
public class TodoListController {

    @Autowired
    private TodoListService todoListService;

    private TodoItemMapper todoItemMapper=new TodoItemMapper();

    @GetMapping
    public List<TodoItem> getAllItems(){
        return todoListService.getAllItems();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoItem addTodoItem(@RequestBody TodoItemRequest todoItemRequest){
        return todoListService.addTodoItem(todoItemMapper.toEntity(todoItemRequest));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTodoItem(@PathVariable Integer id){
        todoListService.deleteTodoItem(id);
    }

    @PutMapping("/{id}")
    public TodoItem updateTodoItem(@PathVariable Integer id,@RequestBody TodoItemRequest todoItemRequest){
        return todoListService.updateTodoItem(id,todoItemMapper.toEntity(todoItemRequest));
    }
}
