package com.todo.TodoApp.service;

import com.todo.TodoApp.dto.UserRequest;
import com.todo.TodoApp.entity.User;

public interface UserService {
    void register(UserRequest userRequest);
    User currentUser();


}
