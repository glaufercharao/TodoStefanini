package com.gsam.technology.todostefanini.adapter.in.controller;

import com.gsam.technology.todostefanini.adapter.in.dtos.ResponseTodo;
import com.gsam.technology.todostefanini.adapter.in.dtos.TodoDTO;
import com.gsam.technology.todostefanini.application.core.domain.Todo;
import com.gsam.technology.todostefanini.application.port.in.CreateTodoPortIn;
import com.gsam.technology.todostefanini.mappers.TodoMapper;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/todo")
public class TodoController {

  public final CreateTodoPortIn createTodoPortIn;
  private final TodoMapper mapper;

  public TodoController(CreateTodoPortIn createTodoPortIn, TodoMapper mapper) {
    this.createTodoPortIn = createTodoPortIn;
    this.mapper = mapper;
  }
  @GetMapping
  public ResponseEntity<Page<ResponseTodo>> getAll(Pageable pageable){
    Page<Todo> todo = createTodoPortIn.getAllTodo(pageable);
    return ResponseEntity.ok(todo.map(mapper::toResponseTodo));
  }
  @GetMapping("/{id}")
  public ResponseEntity<ResponseTodo> getTodoById(@Valid @PathVariable Long id) {
    if (id == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    Todo todo = createTodoPortIn.getTodo(id);
    return ResponseEntity.ok(mapper.toResponseTodo(todo));
  }
  @PostMapping
  public ResponseEntity saveTodo(@Valid @RequestBody TodoDTO todoDTO){
    Todo todo = mapper.toTodoFromTodoDTO(todoDTO);
    createTodoPortIn.saveTodo(todo);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
  @PutMapping("/{id}")
  public ResponseEntity<ResponseTodo> update(@PathVariable Long id, @Valid @RequestBody TodoDTO todoDTO) {
    if (id == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    Todo todo = mapper.toTodoFromTodoDTO(todoDTO);
    todo.setId(id);
    todo = createTodoPortIn.updateTodo(todo);
    return ResponseEntity.ok(mapper.toResponseTodo(todo));
  }
  @DeleteMapping("/{id}")
  public ResponseEntity deleteById(@PathVariable Long id){
    if(id == null){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    createTodoPortIn.deleteTodoById(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
