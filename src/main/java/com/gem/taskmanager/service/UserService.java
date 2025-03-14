package com.gem.taskmanager.service;

import com.gem.taskmanager.model.User;
import com.gem.taskmanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //BEAN
public class UserService
{
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers()
    {
        return userRepository.findAll();
    }
    public User addUser(User user)
    {
        return userRepository.save(user);
    }
}
