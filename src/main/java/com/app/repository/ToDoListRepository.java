package com.app.repository;

import java.util.List;

import com.app.domain.ToDoList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListRepository extends CrudRepository<ToDoList, Long>  {

    ToDoList findFirstByOrderByPostedOnDesc();

    List<ToDoList> findAllByOrderByPostedOnDesc();

    ToDoList findBySlug(String slug);

    List<ToDoList> findAllByUserIdOrderByPostedOnDesc(Long id);
}
