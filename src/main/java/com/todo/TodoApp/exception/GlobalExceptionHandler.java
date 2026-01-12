package com.todo.TodoApp.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(ResourceNotFoundException ex, HttpServletRequest request){
        ApiError error = ApiError.builder()
                .timeStamp(LocalDateTime.now())
                .status(404)
                .error(ex.getMessage())
                .message("RESOURCE_NOT_FOUND")
                .path(request.getRequestURI())
                .build();
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> handleBadRequest(BadRequestException ex,HttpServletRequest request){
        ApiError error = ApiError.builder()
                .timeStamp(LocalDateTime.now())
                .status(400)
                .error(ex.getMessage())
                .message("BAD_REQUEST")
                .path(request.getRequestURI())
                .build();
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
