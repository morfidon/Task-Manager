package com.gem.taskmanager.repository;

import com.gem.taskmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>
{
    Optional<User> findByEmail(String email);
    //empty result .empty().
}
