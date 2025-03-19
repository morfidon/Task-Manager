package com.gem.taskmanager.repository;

import com.gem.taskmanager.model.Task;
import com.gem.taskmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer>
{
    List<Task> findByUser(User user);
    //Get all tasks from SPECIFIC user
}
