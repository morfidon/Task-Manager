package com.gem.taskmanager.controller;

import com.gem.taskmanager.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController
{
    @GetMapping("/users")
    public List<User> getUsers()
    {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "John", "<EMAIL>", "123456"));
        users.add(new User(2, "Jane", "<EMAIL>", "123456"));
        users.add(new User(3, "Jill", "<EMAIL>", "123456"));
        users.add(new User(4, "Jack", "<EMAIL>", "123456"));
        return users;
    }
}
//MODEL - SHAPE, FORMULA - DATA - MVC - Model View Controller - VIEW - REACT - VUE -
// JSON