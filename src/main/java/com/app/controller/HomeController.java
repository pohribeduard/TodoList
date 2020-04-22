package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.service.ToDoService;

@Controller
public class HomeController {

    private ToDoService toDoService;

    @Autowired
    public HomeController(ToDoService toDoService){
        this.toDoService = toDoService;
    }

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("post", toDoService.getLatestPost());
        return "index";
    }

}
