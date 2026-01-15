package com.todo.TodoApp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tasks")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String descriptions;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
