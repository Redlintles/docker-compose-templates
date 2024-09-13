package com.example.spring.tutorials.models;

import java.util.List;

public class ValidationErrorResponse {
  private List<String> errors;
  private Integer statusCode = 422;
  private String message = "Validation Failed";

  public ValidationErrorResponse(List<String> errors) {
    this.errors = errors;
  }

  public List<String> getErrors() {
    return errors;
  }

  public void SetErrors(List<String> errors) {
    this.errors = errors;
  }

  public Integer getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(Integer statusCode) {
    this.statusCode = statusCode;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
