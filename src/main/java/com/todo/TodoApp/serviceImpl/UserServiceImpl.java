package com.todo.TodoApp.serviceImpl;

import com.todo.TodoApp.dto.UserRequest;
import com.todo.TodoApp.entity.User;
import com.todo.TodoApp.exception.BadRequestException;
import com.todo.TodoApp.repo.UserRepository;
import com.todo.TodoApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void register(UserRequest userRequest) {
        if(userRepository.findByUsername(userRequest.getUsername()).isPresent()){
            throw new BadRequestException("Username is Already exists");
        }
        User user = User.builder()
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .build();
        userRepository.save(user);
    }
}
