package com.example.spring.tutorials.handlers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.spring.tutorials.models.ValidationErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
    List<String> errorMessages = new ArrayList<>();

    ex.getBindingResult().getAllErrors().forEach((err) -> {

      String message = err.getDefaultMessage();

      errorMessages.add(message);
    });

    ValidationErrorResponse errorResponse = new ValidationErrorResponse(errorMessages);

    return ResponseEntity.badRequest().body(errorResponse);
  }
}
