package com.tasktree.service;

import com.tasktree.model.TaskGraph;

import java.util.Optional;

public interface TaskService {
    Optional<TaskGraph> getById(Long Id);
    TaskGraph createByTitle(String title);
}
