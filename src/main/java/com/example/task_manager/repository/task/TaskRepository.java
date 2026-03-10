package com.example.task_manager.repository.task;

import com.example.task_manager.entity.task.TaskEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TaskRepository {
    @Select("SELECT id, title, description, status, deadline, created_at FROM tasks;")
    List<TaskEntity> select();
}
