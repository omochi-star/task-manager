package com.example.task_manager.controller.task;

import com.example.task_manager.entity.task.TaskEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record TaskDTO(
        long id,
        String title,
        String description,
        String status,
        LocalDate deadline,
        LocalDateTime createdAt
) {
    public static TaskDTO toDTO(TaskEntity entity) {
        return new TaskDTO(
                entity.id(),
                entity.title(),
                entity.description(),
                entity.status().name(),
                entity.deadline(),
                entity.createdAt()
        );
    }
}
