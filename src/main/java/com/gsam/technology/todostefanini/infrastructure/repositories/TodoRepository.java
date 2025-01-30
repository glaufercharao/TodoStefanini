package com.gsam.technology.todostefanini.infrastructure.repositories;

import com.gsam.technology.todostefanini.application.core.domain.enums.Status;
import com.gsam.technology.todostefanini.infrastructure.entities.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
  @Modifying
  @Transactional
  @Query(value = "UPDATE TodoEntity as t SET t.title=:title, t.description=:description, t.status=:status WHERE t.id=:id")
  void modifyingQueryUpdateTodo(@Param("id")Long id, @Param("title")String title, @Param("description")String description,
                                @Param("status") Status status);
  @Modifying
  @Transactional
  @Query(value = "UPDATE TodoEntity as t " +
          "SET t.title=:title, t.description=:description, t.status=:status, t.atFinished=:atFinished WHERE t.id=:id")
  void modifyingQueryTodoFinish(@Param("id")Long id, @Param("title")String title, @Param("description")String description,
                                @Param("status") Status status, @Param("atFinished") LocalDate atFinished);
}
