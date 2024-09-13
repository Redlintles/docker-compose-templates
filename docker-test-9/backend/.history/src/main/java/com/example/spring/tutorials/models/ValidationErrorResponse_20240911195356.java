package com.example.spring.tutorials.models;

import java.util.List;

public class ValidationErrorResponse {
  public List<String> errors;

  public ValidationErrorResponse(List<String> errors) {
    this.errors = errors;
  }
}
