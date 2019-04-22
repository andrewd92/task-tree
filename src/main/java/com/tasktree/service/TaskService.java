package com.tasktree.service;

import com.tasktree.model.Task;

import java.util.Optional;

public interface TaskService {
    Optional<Task> getById(Long Id);
    Task createByTitle(String title);
}
