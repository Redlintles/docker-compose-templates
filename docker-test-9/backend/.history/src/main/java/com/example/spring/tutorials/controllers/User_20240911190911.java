package com.example.spring.tutorials.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController()
public class User {
  @GetMapping()
  public String hello() {
    return "Hello User";
  }
}
