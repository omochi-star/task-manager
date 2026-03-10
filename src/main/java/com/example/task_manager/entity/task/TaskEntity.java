package com.example.task_manager.entity.task;

import com.example.task_manager.service.task.TaskStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record TaskEntity(
        Long id,
        String title,
        String description,
        TaskStatus status,
        LocalDate deadline,
        LocalDateTime createdAt
) {
}
