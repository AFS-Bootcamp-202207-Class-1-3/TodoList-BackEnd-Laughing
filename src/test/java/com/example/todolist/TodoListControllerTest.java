package com.example.todolist;

import com.example.todolist.entity.TodoItem;
import com.example.todolist.repository.TodoListRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class TodoListControllerTest {

    @Autowired
    private TodoListRepository todoListRepository;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    public void cleanDB() {
        todoListRepository.deleteAll();
    }

    @Test
    public void should_return_all_todos_when_get_all_todos_given_nothing() throws Exception {
        TodoItem todoItem = todoListRepository.save(new TodoItem(0, "dsadjkls", false));
        mockMvc.perform(MockMvcRequestBuilders.get("/Todos"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.*", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(todoItem.getId()));
    }
}
