package com.example.task_manager.controller.task;

import java.time.LocalDate;

public record TaskForm(
        String title,
        String description,
        LocalDate deadline
) {
}
