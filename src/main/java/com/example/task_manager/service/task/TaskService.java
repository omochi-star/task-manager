package com.example.task_manager.service.task;

import com.example.task_manager.controller.task.TaskForm;
import com.example.task_manager.controller.task.TaskNotFoundException;
import com.example.task_manager.entity.task.TaskEntity;
import com.example.task_manager.repository.task.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<TaskEntity> find() {
        return taskRepository.select();
    }

    @Transactional
    public void create(TaskEntity newEntity) {
        taskRepository.insert(newEntity);
    }

    public Optional<TaskEntity> findById(long taskId) {
        return taskRepository.findById(taskId);
    }

    @Transactional
    public void update(long id, TaskForm form) {
        TaskEntity old = taskRepository.findById(id)
                .orElseThrow(TaskNotFoundException::new);

        TaskEntity updated = new TaskEntity(
                id,
                form.title(),
                form.description(),
                TaskStatus.valueOf(form.status()),
                form.deadline(),
                old.createdAt()
        );

        taskRepository.update(updated);
    }

    @Transactional
    public void delete(long id) {
        taskRepository.delete(id);
    }
}
