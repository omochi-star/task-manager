package com.example.task_manager.service.task;

import com.example.task_manager.entity.task.TaskEntity;
import com.example.task_manager.repository.task.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<TaskEntity> find() {
        return taskRepository.select();
    }
}
