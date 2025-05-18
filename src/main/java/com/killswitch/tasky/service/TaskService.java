package com.killswitch.tasky.service;

import com.killswitch.tasky.model.entity.Task;

import java.util.Optional;

public interface TaskService {
    Iterable<Task> getAllTasks();

    Optional<Task> getTask(Long id);

    boolean deleteTask(Long id);

    Task saveTask(Task task);
}
