package com.gsam.technology.todostefanini.application.port.in;

import com.gsam.technology.todostefanini.application.core.domain.Todo;

import java.util.List;

public interface CreateTodoPortIn {
  void saveTodo(Todo todo);
  Todo getTodo(Long id);
  Todo updateTodo(Todo todo);
  List<Todo> getAllTodo();
  void deleteTodoById(Long id);
}
