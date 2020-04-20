package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.domain.ToDoList;
import com.app.repository.ToDoListRepository;

@Service
public class ToDoService {
    
    private ToDoListRepository toDoListRepository;
    
    @Autowired
    public ToDoService(ToDoListRepository toDoListRepository){ this.toDoListRepository = toDoListRepository;}

    public ToDoList getLatestPost(){
        return toDoListRepository.findFirstByOrderByPostedOnDesc();
    }

    public List<ToDoList> list() {
        return toDoListRepository.findAllByOrderByPostedOnDesc();
    }

    public ToDoList getBySlug(String slug) {
        return toDoListRepository.findBySlug(slug);
    }

    public List<ToDoList> listByUser(Long id) {
        return toDoListRepository.findAllByUserIdOrderByPostedOnDesc(id);
    }

    public ToDoList get(Long id) {
        return toDoListRepository.findOne(id);
    }

    public ToDoList save(ToDoList post) {
        return toDoListRepository.save(post);
    }

    public void delete(Long id) {
        toDoListRepository.delete(id);
    }
    
}
