package com.baeldung.controller;

import java.util.List;

import com.baeldung.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.baeldung.service.ArticleWorkflowService;

@RestController
public class ArticleWorkflowController {
    @Autowired
    private ArticleWorkflowService service;
    @PostMapping("/submit")
    public void submit(@RequestBody User user) {
        service.startProcess(user);
    }
    @GetMapping("/allTasks")
    public List<Step> getAllTasks() {
        return service.getAllTasks();
    }
    @GetMapping("/tasks")
    public List<Step> getTasksForUser(@RequestParam String userId) {
        return service.getOpenTasksForUser(userId);
    }
    @GetMapping("/tasks/completed")
    public List<Step> getCompletedTasksForUser(@RequestParam String userId) {
        return service.getCompletedTasksForUser(userId);
    }
    @GetMapping("/subtasks")
    public List<Subtask> getSubtasks(@RequestParam String processId) {
        return service.getSubtasks(processId);
    }
    @PostMapping("/review")
    public void review(@RequestBody Approval approval) {
        service.submitReview(approval);
    }
    @GetMapping("/dashboard")
    public DashboardData getDashboardData(@RequestParam String userId) {
        return service.getDashboardData(userId);
    }
}