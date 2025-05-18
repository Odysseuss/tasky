package com.killswitch.tasky.service;

import com.killswitch.tasky.model.entity.Task;
import com.killswitch.tasky.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Iterable<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getTask(Long id) {

        return taskRepository.findById(id);
    }

    @Override
    public boolean deleteTask(Long id) {

        boolean exists = taskRepository.existsById(id);
        if (exists) {
            taskRepository.deleteById(id);
        }
        return exists;
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }
}
