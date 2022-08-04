package com.example.todolist.service;

import com.example.todolist.entity.TodoItem;
import com.example.todolist.exception.TodoItemNotFoundException;
import com.example.todolist.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListService {
    @Autowired
    private TodoListRepository todoListRepository;

    public List<TodoItem> getAllItems(){
        return todoListRepository.findAll();
    }

    public TodoItem addTodoItem(TodoItem todoItem){
        todoItem.setDone(false);
        return todoListRepository.save(todoItem);
    }

    public void deleteTodoItem(Integer id) {
        todoListRepository.deleteById(id);
    }

    public TodoItem updateTodoItem(Integer id, TodoItem toUpdateItem) {
        TodoItem todoItem=todoListRepository.findById(id).orElseThrow(TodoItemNotFoundException::new);
        todoItem.merge(toUpdateItem);
        return todoListRepository.save(todoItem);
    }
}
