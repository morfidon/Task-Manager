package com.gem.taskmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{
    @GetMapping("/users")
    public String getUsers(){
        return "Here is a list of users of our application";
    }
}
//MODEL - SHAPE, FORMULA - DATA - MVC - Model View Controller - VIEW - REACT - VUE -