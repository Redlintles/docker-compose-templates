package com.example.spring.tutorials.models;

public class SanityCheck {
  private String message = "Everything is Working";
  private Integer statusCode = 200;


  public SanityCheck(String message, Integer statusCodeInteger) {
    this.message = message;
    this.statusCode = statusCode;

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
