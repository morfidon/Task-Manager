package com.gem.taskmanager.init;

import com.gem.taskmanager.model.Role;
import com.gem.taskmanager.model.User;
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

    public DataLoader(PasswordEncoder passwordEncoder, UserRepository userRepository)
    {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            User admin = new User("admin", "admin", passwordEncoder.encode("admin123"), Role.ADMIN);
            User user = new User("user", "user", passwordEncoder.encode("user123"), Role.USER);

            userRepository.saveAll(List.of(admin, user));
            System.out.println( "Loaded Sample Users");
        }

    }


}
