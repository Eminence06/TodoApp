package com.todo.TodoApp.dto;


import com.todo.TodoApp.entity.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class TaskResponse {
    private Long id;
    private String title;
    private String desc;
    private TaskStatus status;
}
