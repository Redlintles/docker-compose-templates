package com.example.spring.tutorials.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserLoginDTO {
  @NotBlank()
  @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
  private String username;
}
