package com.ijse.hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.hello.entity.Task;
import com.ijse.hello.service.TaskService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/tasks")
    public ResponseEntity<?> createTask(@RequestBody Task task) { // ? = any object
        if (task.getTaskName() == null || task.getTaskName() == "") {
            return ResponseEntity.status(400).body("Please enter a valid Task name");
        }

        if (task.getPriority() == null) {
            return ResponseEntity.status(400).body("Please enter a valid priority");
        }

        try {
            Task createdTask = taskService.createTask(task);
            return ResponseEntity.status(201).body(createdTask);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }

    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.status(200).body(tasks);
    }

    @GetMapping("/tasks/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long taskId) {
        Task task = taskService.getTaskById(taskId);
        if (task == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.status(200).body(task);
        }
    }

    @PutMapping("tasks/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @RequestBody Task task) {
        Task updateTask = taskService.updateTask(taskId, task);

        if (updateTask == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.status(200).body(updateTask);
        }
    }

    @DeleteMapping("/tasks/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }
}
