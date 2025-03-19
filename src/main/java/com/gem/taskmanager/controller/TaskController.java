package com.gem.taskmanager.controller;

import com.gem.taskmanager.model.Task;
import com.gem.taskmanager.model.User;
import com.gem.taskmanager.service.TaskService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController
{
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks(@AuthenticationPrincipal User user)
    {
        return taskService.getTasksForUser(user);
    }
    @PostMapping
    public Task addTask(@RequestBody Task task, @AuthenticationPrincipal User user)
    {
        return taskService.addTask(task, user);
    }
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id, @AuthenticationPrincipal User user)
    {
        taskService.deleteTask(id, user);
    }
}
