package com.example.task_manager.repository.task;

import com.example.task_manager.entity.task.TaskEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TaskRepository {
    @Select("""
            SELECT
            id,
            title,
            description,
            status,
            deadline,
            created_at AS createdAt
            FROM tasks;
            """)
    List<TaskEntity> select();

    @Insert("""
            INSERT INTO tasks (title, description, status, deadline, created_at)
            VALUES (#{task.title}, #{task.description}, #{task.status},#{task.deadline},#{task.createdAt})
            """)
    void insert(@Param("task") TaskEntity newEntity);

    @Select("select * from tasks where id = #{taskId}")
    Optional<TaskEntity> findById(long taskId);

    @Update("""
            UPDATE tasks
            SET
                title = #{task.title},
                description = #{task.description},
                status = #{task.status},
                deadline = #{task.deadline}
            WHERE
                id = #{task.id}
            """)
    void update(@Param("task") TaskEntity task);

    @Delete("DELETE FROM tasks WHERE id = #{id}")
    void delete(@Param("id") long id);
}
