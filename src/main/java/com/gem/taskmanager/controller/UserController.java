package com.gem.taskmanager.controller;

import com.gem.taskmanager.model.User;
import com.gem.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("users/")
public class UserController
{

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }
    @GetMapping
    public List<User> getUsers()
    {
        return userRepository.findAll();
    }
    @PostMapping
    public User addUser(@RequestBody User user)
    {
        return userRepository.save(user);
    }


}
// HTTP REQUEST - ONE OF THE TYPE - GET
// POST /JSON

