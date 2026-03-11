package com.example.task_manager.controller.task;

import com.example.task_manager.entity.task.TaskEntity;
import com.example.task_manager.service.task.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.springframework.web.servlet.function.ServerResponse.status;

public record TaskForm(
        @NotBlank
        @Size(max = 256, message = "256文字以内で入力してください。")
        String title,

        String description,
        LocalDate deadline
) {
    public TaskEntity toEntity() {
        return new TaskEntity(
                null,
                title(),
                description(),
                TaskStatus.TODO,
                deadline(),
                LocalDateTime.now()
        );
    }

}
