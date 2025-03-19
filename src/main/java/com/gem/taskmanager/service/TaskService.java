package com.gem.taskmanager.service;

import com.gem.taskmanager.model.Task;
import com.gem.taskmanager.model.User;
import com.gem.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService
{
    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository)
    {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasksForUser(User user)
    {
        return taskRepository.findByUser(user);
    }

    public Task addTask(Task task, User user)
    {
        task.setUser(user);
        return taskRepository.save(task);
    }

    public void deleteTask(int taskId, User user)
    {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new IllegalArgumentException("Invalid task id: " + taskId));

        if(!task.getUser().getUsername().equals(user.getUsername()))
        {
            throw new IllegalArgumentException("Task does not belong to user");
        }

        taskRepository.delete(task);
    }
}
