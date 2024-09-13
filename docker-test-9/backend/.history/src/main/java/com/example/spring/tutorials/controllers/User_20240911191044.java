package com.example.spring.tutorials.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.tutorials.repositories.UserRepository;

@RequestMapping("/users")
@RestController()
public class User {
  @Autowired
  private UserRepository userRepository;

  @PostMapping
  public User createUser(@RequestBody User user) {
    return "Hello User";
  }
}
