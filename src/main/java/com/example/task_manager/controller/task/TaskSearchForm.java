package com.example.task_manager.controller.task;

import com.example.task_manager.entity.task.TaskSearchEntity;
import com.example.task_manager.service.task.TaskStatus;

import java.util.List;
import java.util.Optional;

public record TaskSearchForm(
        String title,
        List<String> status,
        String sort
) {
    public TaskSearchEntity toEntity() {
        var statusEntityList = Optional.ofNullable(status())
                .map(statusList -> statusList.stream().map(TaskStatus::valueOf).toList())
                .orElse(List.of());
        return new TaskSearchEntity(title(),statusEntityList,sort());
    }
    public TaskSearchDTO toDTO() {
        return new TaskSearchDTO(title, status,sort);
    }
}

