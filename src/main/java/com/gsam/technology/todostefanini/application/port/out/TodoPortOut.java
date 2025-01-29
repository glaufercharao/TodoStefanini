package com.gsam.technology.todostefanini.application.port.out;

import com.gsam.technology.todostefanini.application.core.domain.Todo;

import java.util.List;

public interface TodoPortOut {
  Todo getOne(Long id);
  void pesist(Todo todo);
  Todo update(Todo todo);
  List<Todo> getAll();
  void delete(Long id);
}
