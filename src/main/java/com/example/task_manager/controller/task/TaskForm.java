package com.example.task_manager.controller.task;

import com.example.task_manager.entity.task.TaskEntity;
import com.example.task_manager.service.task.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.springframework.web.servlet.function.ServerResponse.status;

public record TaskForm(
        @NotBlank
        @Size(max = 256, message = "256文字以内で入力してください。")
        String title,

        String description,

        @NotBlank
        @Pattern(regexp = "TODO|DOING|DONE", message="Todo, Doing, Done のいずれかを選択してください。")
        String status,

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate deadline
) {
    public static TaskForm fromEntity(TaskEntity taskEntity) {
        return new TaskForm(
                taskEntity.title(),
                taskEntity.description(),
                taskEntity.status().name(),
                taskEntity.deadline()
        );
    }
    public TaskEntity toEntity() {
        return new TaskEntity(
                null,
                title(),
                description(),
                TaskStatus.valueOf(status()),
                deadline(),
                LocalDateTime.now()
        );
    }

}
