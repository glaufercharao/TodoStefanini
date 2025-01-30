package com.gsam.technology.todostefanini.application.port.in;

import com.gsam.technology.todostefanini.application.core.domain.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CreateTodoPortIn {
  void saveTodo(Todo todo);
  Todo getTodo(Long id);
  Todo updateTodo(Todo todo);
  Page<Todo> getAllTodo(Pageable pageable);
  void deleteTodoById(Long id);
}
