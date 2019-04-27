package com.tasktree.service;

import com.tasktree.model.Task;
import com.tasktree.model.TaskGraph;

import java.util.Optional;

public interface TaskService {
    Optional<Task> getById(Long Id);
    Task createByTitle(String title);
}
