package com.gsam.technology.todostefanini.application.core.domain;

import com.gsam.technology.todostefanini.application.core.domain.enums.Status;

import java.time.LocalDate;

public class Todo {
    private Long id;
    private String title;
    private String description;
    private Status status;
    private LocalDate atCreated;

  public Todo() {
  }

  public Todo(Long id, String title, String description, Status status, LocalDate atCreated) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.status = status;
    this.atCreated = atCreated;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public LocalDate getAtCreated() {
    return atCreated;
  }

  public void setAtCreated(LocalDate atCreated) {
    this.atCreated = atCreated;
  }
}
