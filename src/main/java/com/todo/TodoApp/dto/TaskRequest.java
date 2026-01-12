package com.todo.TodoApp.dto;

import com.todo.TodoApp.entity.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TaskRequest {
    @NotBlank
    private String title;
    private String desc;
    @NotNull
    private TaskStatus status;
}
