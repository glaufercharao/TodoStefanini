package com.gsam.technology.todostefanini.adapter.in.dtos;

import com.gsam.technology.todostefanini.application.core.domain.enums.Status;

public record TodoDTO(
         String title,
         String description,
         Status status) {
}
