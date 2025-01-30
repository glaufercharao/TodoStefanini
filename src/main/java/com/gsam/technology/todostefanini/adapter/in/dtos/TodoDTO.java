package com.gsam.technology.todostefanini.adapter.in.dtos;

import com.gsam.technology.todostefanini.application.core.domain.enums.Status;
import jakarta.validation.constraints.NotBlank;

public record TodoDTO(
        @NotBlank
         String title,
        @NotBlank
         String description,
         Status status) {
}
