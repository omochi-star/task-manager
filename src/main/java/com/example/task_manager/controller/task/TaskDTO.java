package com.example.task_manager.controller.task;

import com.example.task_manager.entity.task.TaskEntity;

import java.time.LocalDate;

public record TaskDTO(
        long id,
        String title,
        String description,
        String status,
        LocalDate deadline
) {
    public static TaskDTO toDTO(TaskEntity entity) {
        return new TaskDTO(
                entity.id(),
                entity.title(),
                entity.description(),
                entity.status().name(),
                entity.deadline()
        );
    }
}
