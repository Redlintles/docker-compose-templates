package com.example.spring.tutorials.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserLoginDTO {
  @NotBlank()
  @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
  private String username;

  @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Password must contain at least a lowercase, a uppercase, a symbol and a number and have min 8 characters long")
  private String password;
}
