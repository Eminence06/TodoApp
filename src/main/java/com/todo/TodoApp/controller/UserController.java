package com.todo.TodoApp.controller;

import com.todo.TodoApp.dto.UserRequest;
import com.todo.TodoApp.serviceImpl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@Valid @RequestBody UserRequest userRequest){
        userService.register(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
