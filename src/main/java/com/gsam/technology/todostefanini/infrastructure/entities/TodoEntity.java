package com.gsam.technology.todostefanini.infrastructure.entities;

import com.gsam.technology.todostefanini.application.core.domain.enums.Status;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@Table(name = "todo")
@EntityListeners(AuditingEntityListener.class)
public class TodoEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String description;
  @Enumerated(EnumType.STRING)
  private Status status;
  @CreatedDate
  private LocalDate atCreated;
  private LocalDate atFinished;

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

  public LocalDate getAtFinished() {
    return atFinished;
  }

  public void setAtFinished(LocalDate atFinished) {
    this.atFinished = atFinished;
  }
}
