package com.example.todolist.advice;

import com.example.todolist.exception.TodoItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({TodoItemNotFoundException.class})
    public ErrorResponse handlerNotFoundException(Exception exception){
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(),exception.getMessage());
    }
    
}
