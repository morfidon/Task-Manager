package com.gem.taskmanager.controller;

import com.gem.taskmanager.model.User;
import com.gem.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController
{

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }
    @GetMapping("/users")
    public List<User> getUsers()
    {
        return userRepository.findAll();
    }
}
//MODEL - SHAPE, FORMULA - DATA - MVC - Model View Controller - VIEW - REACT - VUE -
// JSON