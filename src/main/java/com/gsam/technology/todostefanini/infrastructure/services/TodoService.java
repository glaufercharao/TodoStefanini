package com.gsam.technology.todostefanini.infrastructure.services;

import com.gsam.technology.todostefanini.application.core.domain.Todo;
import com.gsam.technology.todostefanini.application.core.domain.enums.Status;
import com.gsam.technology.todostefanini.application.port.out.TodoPortOut;
import com.gsam.technology.todostefanini.infrastructure.entities.TodoEntity;
import com.gsam.technology.todostefanini.infrastructure.repositories.TodoRepository;
import com.gsam.technology.todostefanini.infrastructure.services.exceptions.DatabaseException;
import com.gsam.technology.todostefanini.infrastructure.services.exceptions.ResourceNotFoundException;
import com.gsam.technology.todostefanini.mappers.TodoMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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
      throw new ResourceNotFoundException("Task not found");
    }
    return mapperEntity.toTodo(todo.get());
  }

  @Override
  @Transactional
  public void pesist(Todo todo) {
    var todoEntity = mapperEntity.toTodoEntity(todo);
    todoEntity.setStatus(Status.PENDING);
    repository.save(todoEntity);
  }

  @Override
  @Transactional
  public Todo update(Todo todo) {
    var todoEntity = repository.findById(todo.getId());
    if(!todoEntity.isPresent()){
      throw new ResourceNotFoundException("Task not found "+ todo.getId());
    }
    if(todo.getStatus().equals(Status.DONE) && todoEntity.get().getStatus() != Status.DONE){
      repository.modifyingQueryTodoFinish(todo.getId(), todo.getTitle(),
              todo.getDescription(),todo.getStatus(), LocalDate.now());
    } else {
      repository.modifyingQueryUpdateTodo(todo.getId(), todo.getTitle(),
              todo.getDescription(),todo.getStatus());
    }
    return mapperEntity.toTodo(todoEntity.get());
  }

  @Override
  @Transactional(readOnly = true)
  public Page<Todo> getAll(Pageable pageable) {
    Page<TodoEntity> todoList = repository.findAll(pageable);
    return todoList.map(mapperEntity::toTodo);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    try {
      Optional<TodoEntity> todo = repository.findById(id);
      if(!todo.isPresent()) {
        throw new ResourceNotFoundException("Id "+ id +", not found!");
      }
      repository.deleteById(id);
    }catch (DataIntegrityViolationException e){
      throw  new DatabaseException("Integrity violation");
    }
  }
}
