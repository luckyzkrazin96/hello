package com.ijse.hello.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.hello.entity.Task;

@Service
public interface TaskService {
    Task createTask(Task task);

    List<Task> getAllTasks();

    Task getTaskById(Long id);

    Task updateTask(Long id, Task task);

    void deleteTask(Long id);
}
