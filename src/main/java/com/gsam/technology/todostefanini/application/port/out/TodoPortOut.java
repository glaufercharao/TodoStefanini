package com.gsam.technology.todostefanini.application.port.out;

import com.gsam.technology.todostefanini.application.core.domain.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TodoPortOut {
  Todo getOne(Long id);
  void pesist(Todo todo);
  Todo update(Todo todo);
  Page<Todo> getAll(Pageable pageable);
  void delete(Long id);
}
