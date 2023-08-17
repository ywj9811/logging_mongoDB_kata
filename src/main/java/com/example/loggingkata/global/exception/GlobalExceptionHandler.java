package com.example.loggingkata.global.exception;

import com.example.loggingkata.global.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClassCastException.class)
    public ResponseEntity<ErrorResponse> AuthorizationException(ClassCastException ex) {
        String errorCode = "500";
        return ResponseEntity.ok(new ErrorResponse(errorCode, ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> AllException(ClassCastException ex) {
        String errorCode = "500";
        return ResponseEntity.ok(new ErrorResponse(errorCode, ex.getMessage()));
    }
}
