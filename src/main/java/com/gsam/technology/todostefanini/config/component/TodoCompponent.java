package com.gsam.technology.todostefanini.config.component;

import com.gsam.technology.todostefanini.application.port.out.TodoPortOut;
import com.gsam.technology.todostefanini.application.usecase.CreateTodo;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TodoCompponent {

  @Bean
  public CreateTodo createTodoUseCase(TodoPortOut todoPortOut){
    return new CreateTodo(todoPortOut);
  }
}
