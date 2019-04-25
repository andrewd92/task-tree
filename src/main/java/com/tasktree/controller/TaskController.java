package com.tasktree.controller;

import com.tasktree.model.TaskGraph;
import com.tasktree.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TaskController {
    private TaskService service;

    @RequestMapping("/task/{id}")
    public TaskGraph getByTitle(@PathVariable Long id) {
        return service.getById(id).orElse(new TaskGraph());
    }

    @RequestMapping("/create/{title}")
    public TaskGraph create(@PathVariable String title) {
        return service.createByTitle(title);
    }
}
