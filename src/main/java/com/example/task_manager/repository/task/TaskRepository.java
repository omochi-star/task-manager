package com.example.task_manager.repository.task;

import com.example.task_manager.entity.task.TaskEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TaskRepository {
    @Select("SELECT id, title, description, status, deadline, created_at FROM tasks;")
    List<TaskEntity> select();

    @Insert("""
            INSERT INTO tasks (title, description, status, deadline, created_at)
            VALUES (#{task.title}, #{task.description}, #{task.status},#{task.deadline},#{task.createdAt})
            """)
    void insert(@Param("task") TaskEntity newEntity);

    @Select("select * from tasks where id = #{taskId}")
    TaskEntity findById(long taskId);
}
