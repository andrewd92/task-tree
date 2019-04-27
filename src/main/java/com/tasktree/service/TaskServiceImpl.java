package com.tasktree.service;

import com.tasktree.model.Task;
import com.tasktree.model.TaskGraph;
import com.tasktree.repository.TaskGraphRepository;
import com.tasktree.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskGraphRepository graphRepository;

    private final TaskRepository taskRepository;

    @Override
    public Task createByTitle(String title) {
        Task task = new Task(title);
        taskRepository.save(task);

        saveToGraph(task);

        return task;
    }

    @Override
    public Optional<Task> getById(Long Id) {
        return taskRepository.findById(Id);
    }

    private void saveToGraph(Task task) {
        TaskGraph model = new TaskGraph(task);
        graphRepository.save(model);
    }
}
