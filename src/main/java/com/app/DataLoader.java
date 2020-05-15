package com.app;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.domain.User;
import com.app.domain.ToDoList;
import com.app.repository.UserRepository;
import com.app.repository.ToDoListRepository;

@Component
public class DataLoader {

    private ToDoListRepository toDoListRepository;
    private UserRepository userRepository;

    @Autowired
    public DataLoader(ToDoListRepository toDoListRepository,UserRepository userRepository){
        this.toDoListRepository = toDoListRepository;
        this.userRepository = userRepository;
    }

    @PostConstruct
    private void loadData(){

        toDoListRepository.deleteAll();
        userRepository.deleteAll();

        // create an author
        User dv = new User("Admin","Admin","admin@gmail.com");
        userRepository.save(dv);
        User dv1 = new User("Admin1","Admin1","admin1@gmail.com");
        userRepository.save(dv1);


    }


}