package com.tasktree.controller;

import com.tasktree.model.Task;
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
    public Task getByTitle(@PathVariable Long id) {
        return service.getById(id).orElse(new Task());
    }

    @RequestMapping("/create/{title}")
    public Task create(@PathVariable String title) {
        return service.createByTitle(title);
    }
}
