package com.example.spring.tutorials.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.tutorials.repositories.UserRepository;

@RequestMapping("/users")
@RestController()
public class User {
  @Autowired
  private UserRepository userRepository;

  @GetMapping()
  public String hello() {
    return "Hello User";
  }
}
