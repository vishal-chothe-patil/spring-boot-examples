package com.killerexpertise.exception.example.exception;

import com.killerexpertise.exception.example.responce.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleCustomerNotFound(CustomerNotFoundException ex) {
        return new ResponseEntity<>(new ApiResponse<>(ex.getMessage(), null), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGenericException(Exception ex) {
        return new ResponseEntity<>(new ApiResponse<>("Something went wrong: " + ex.getMessage(), null),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
