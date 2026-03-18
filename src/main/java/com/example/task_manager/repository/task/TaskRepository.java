package com.example.task_manager.repository.task;

import com.example.task_manager.entity.task.TaskEntity;
import com.example.task_manager.entity.task.TaskSearchEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TaskRepository {
    @Select("""
                        <script>
                            SELECT id, title, description, status, deadline, created_at
                            FROM tasks
                            <where>
                                <if test='condition.title != null and !condition.title.isBlank()'>
                                    title LIKE CONCAT('%', #{condition.title}, '%')
                                </if>
                                <if test='condition.status != null and !condition.status.isEmpty()'>
                                    AND status IN (
                                    <foreach item='item' index='index' collection = 'condition.status' separator=','>
                                        #{item}
                                    </foreach>
                                    )
                                </if>
                            </where>
                        </script>
            """)
    List<TaskEntity> select(@Param("condition") TaskSearchEntity condition);

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
