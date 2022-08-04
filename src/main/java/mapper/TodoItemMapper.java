package mapper;

import com.example.todolist.controller.TodoItemRequest;
import com.example.todolist.entity.TodoItem;
import org.springframework.beans.BeanUtils;

public class TodoItemMapper {
    public TodoItem toEntity(TodoItemRequest todoItemRequest){
        TodoItem todoItem=new TodoItem();
        BeanUtils.copyProperties(todoItemRequest,todoItem);
        return todoItem;
    }
}
