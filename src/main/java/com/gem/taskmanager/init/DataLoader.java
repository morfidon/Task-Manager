package com.gem.taskmanager.init;

import com.gem.taskmanager.model.Role;
import com.gem.taskmanager.model.Task;
import com.gem.taskmanager.model.User;
import com.gem.taskmanager.repository.TaskRepository;
import com.gem.taskmanager.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DataLoader implements CommandLineRunner
{

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    public DataLoader(PasswordEncoder passwordEncoder, UserRepository userRepository, TaskRepository taskRepository)
    {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            User admin = new User("admin", "admin", passwordEncoder.encode("admin123"), Role.ADMIN);
            User user = new User("user", "user", passwordEncoder.encode("user123"), Role.USER);

            userRepository.saveAll(List.of(admin, user));
            System.out.println( "Loaded Sample Users");

            Task adminTask = new Task("Admin Task", "Admin Task Description", admin);
            Task adminTask2 = new Task("Admin Task 2", "Admin Task 2 Description", admin);

            Task userTask = new Task("User Task", "User Task Description", user);
            Task userTask2 = new Task("User Task 2", "User Task 2 Description", user);
            Task userTask3 = new Task("User Task 3", "User Task 3 Description", user);

            taskRepository.saveAll(List.of(adminTask, adminTask2, userTask, userTask2, userTask3));

            System.out.println( "Loaded Sample Tasks");
        }

    }


}
