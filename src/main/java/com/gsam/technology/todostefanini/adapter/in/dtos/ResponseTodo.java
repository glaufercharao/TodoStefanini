package com.gsam.technology.todostefanini.adapter.in.dtos;

import com.gsam.technology.todostefanini.application.core.domain.enums.Status;

import java.time.LocalDate;

public record ResponseTodo(
         Long id,
         String title,
         String description,
         Status status,
         LocalDate atCreated
) {
}
