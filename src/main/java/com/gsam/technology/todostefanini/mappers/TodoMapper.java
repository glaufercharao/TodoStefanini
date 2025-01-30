package com.gsam.technology.todostefanini.mappers;

import com.gsam.technology.todostefanini.adapter.in.dtos.ResponseTodo;
import com.gsam.technology.todostefanini.adapter.in.dtos.TodoDTO;
import com.gsam.technology.todostefanini.application.core.domain.Todo;
import com.gsam.technology.todostefanini.infrastructure.entities.TodoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TodoMapper {
  TodoEntity toTodoEntity(Todo todo);
  Todo toTodo(TodoEntity todoEntity);
  Todo toTodoFromTodoDTO(TodoDTO todoDTO);
  ResponseTodo toResponseTodo(Todo todo);
}
