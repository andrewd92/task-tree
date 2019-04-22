package com.tasktree.service;

import com.tasktree.model.Task;
import com.tasktree.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;

    @Override
    public Task createByTitle(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setDate(new Date());
        task.setDone(false);
        return taskRepository.save(task);
    }

    @Override
    public Optional<Task> getById(Long Id) {
        return taskRepository.findById(Id);
    }
}
