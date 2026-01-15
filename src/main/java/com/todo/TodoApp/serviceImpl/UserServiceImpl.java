package com.todo.TodoApp.serviceImpl;

import com.todo.TodoApp.dto.UserRequest;
import com.todo.TodoApp.entity.User;
import com.todo.TodoApp.exception.BadRequestException;
import com.todo.TodoApp.exception.ResourceNotFoundException;
import com.todo.TodoApp.repo.UserRepository;
import com.todo.TodoApp.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(UserRequest userRequest) {
        if(userRepository.findByUsername(userRequest.getUsername()).isPresent()){
            throw new BadRequestException("Username is Already exists");
        }
        User user = User.builder()
                .username(userRequest.getUsername())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .build();
        userRepository.save(user);
    }

    @Override
    public User currentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(username)
                .orElseThrow(()-> new ResourceNotFoundException("User not found"));
    }
}
