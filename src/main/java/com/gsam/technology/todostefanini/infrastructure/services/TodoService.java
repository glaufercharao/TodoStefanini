package com.gsam.technology.todostefanini.infrastructure.services;

import com.gsam.technology.todostefanini.application.core.domain.Todo;
import com.gsam.technology.todostefanini.application.port.out.TodoPortOut;
import com.gsam.technology.todostefanini.infrastructure.entities.TodoEntity;
import com.gsam.technology.todostefanini.infrastructure.repositories.TodoRepository;
import com.gsam.technology.todostefanini.mappers.TodoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoService implements TodoPortOut {

  private final TodoRepository repository;
  private final TodoMapper mapperEntity;

  public TodoService(TodoRepository repository, TodoMapper mapperEntity) {
    this.repository = repository;
    this.mapperEntity = mapperEntity;
  }

  @Override
  @Transactional(readOnly = true)
  public Todo getOne(Long id) {
    Optional<TodoEntity> todo = repository.findById(id);
    if(!todo.isPresent()){
      throw new RuntimeException("Task not found.");
    }
    return mapperEntity.toTodo(todo.get());
  }

  @Override
  @Transactional
  public void pesist(Todo todo) {
    var todoEntity = mapperEntity.toTodoEntity(todo);
    repository.save(todoEntity);
  }

  @Override
  @Transactional
  public Todo update(Todo todo) {
    var todoEntity = repository.findById(todo.getId());
    if(!todoEntity.isPresent()){
      throw new RuntimeException("Task not found.");
    }
    var todoUpdate = mapperEntity.toTodoEntity(todo);
    repository.save(todoUpdate);
    return todo;
  }

  @Override
  @Transactional(readOnly = true)
  public List<Todo> getAll() {
    List<TodoEntity> todoList = repository.findAll();
    return todoList.stream().map(mapperEntity::toTodo).collect(Collectors.toList());
  }

  @Override
  @Transactional
  public void delete(Long id) {
    Optional<TodoEntity> todo = repository.findById(id);
    if(!todo.isPresent()){
      throw new RuntimeException("Task not found.");
    }
    repository.deleteById(id);
  }
}
