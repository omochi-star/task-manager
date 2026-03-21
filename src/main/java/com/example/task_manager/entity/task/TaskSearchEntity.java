package com.example.task_manager.entity.task;

import com.example.task_manager.service.task.TaskStatus;

import java.util.List;

public record TaskSearchEntity (
        String title,
        List<TaskStatus> status,
        String sort
){
}
