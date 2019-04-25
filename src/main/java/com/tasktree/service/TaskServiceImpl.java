package com.tasktree.service;

import com.tasktree.model.TaskGraph;
import com.tasktree.repository.TaskGraphRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
    private TaskGraphRepository taskRepository;

    @Override
    public TaskGraph createByTitle(String title) {
        TaskGraph task = new TaskGraph();
        task.setTitle(title);
        task.setDate(new Date());
        task.setDone(false);
        return taskRepository.save(task);
    }

    @Override
    public Optional<TaskGraph> getById(Long Id) {
        return taskRepository.findById(Id);
    }
}
