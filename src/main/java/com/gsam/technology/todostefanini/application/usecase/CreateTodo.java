package com.gsam.technology.todostefanini.application.usecase;

import com.gsam.technology.todostefanini.application.core.domain.Todo;
import com.gsam.technology.todostefanini.application.port.in.CreateTodoPortIn;
import com.gsam.technology.todostefanini.application.port.out.TodoPortOut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class CreateTodo implements CreateTodoPortIn {

  private final TodoPortOut todoPortOut;

  public CreateTodo(TodoPortOut todoPortOut) {
    this.todoPortOut = todoPortOut;
  }

  @Override
  public void saveTodo(Todo todo) {
    todoPortOut.pesist(todo);
  }

  @Override
  public Todo getTodo(Long id) {
    return todoPortOut.getOne(id);
  }

  @Override
  public Todo updateTodo(Todo todo) {
    return todoPortOut.update(todo);
  }

  @Override
  public Page<Todo> getAllTodo(Pageable pageable) {
    return todoPortOut.getAll(pageable);
  }

  @Override
  public void deleteTodoById(Long id) {
    todoPortOut.delete(id);
  }
}
