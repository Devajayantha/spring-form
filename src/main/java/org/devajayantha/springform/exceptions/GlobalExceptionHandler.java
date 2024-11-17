package org.devajayantha.springform.exceptions;

import org.devajayantha.springform.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ApiResponse<String>> handleBadCredentialsException(BadCredentialsException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(ApiResponse.error("Invalid email or password", null));
    }

    // Handle validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, List<String>>>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, List<String>> errors = new HashMap<>();

        // Extract field errors and group messages
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.computeIfAbsent(error.getField(), key -> new ArrayList<>()).add(error.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(ApiResponse.error("Invalid field", errors));
    }

    // Handle other exceptions (optional)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleGeneralException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.error("An unexpected error occurred", ex.getMessage()));
    }
}