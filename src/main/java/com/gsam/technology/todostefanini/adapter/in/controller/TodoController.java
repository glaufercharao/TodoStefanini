package com.gsam.technology.todostefanini.adapter.in.controller;

import com.gsam.technology.todostefanini.adapter.in.dtos.TodoDTO;
import com.gsam.technology.todostefanini.application.core.domain.Todo;
import com.gsam.technology.todostefanini.application.port.in.CreateTodoPortIn;
import com.gsam.technology.todostefanini.mappers.TodoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("todo")
public class TodoController {

  public final CreateTodoPortIn createTodoPortIn;
  private final TodoMapper mapper;

  public TodoController(CreateTodoPortIn createTodoPortIn, TodoMapper mapper) {
    this.createTodoPortIn = createTodoPortIn;
    this.mapper = mapper;
  }
  @PostMapping
  public ResponseEntity saveTodo(@RequestBody TodoDTO todoDTO){
    Todo todo = mapper.toTodoFromTodoDTO(todoDTO);
    createTodoPortIn.saveTodo(todo);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
