package com.example.spring.tutorials.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.tutorials.models.UserEntity;
import com.example.spring.tutorials.repositories.UserRepository;

@RequestMapping("/users")
@RestController()
public class User {
  @Autowired
  private UserRepository userRepository;

  @PostMapping
  public UserEntity createUser(@RequestBody UserEntity user) {
    return userRepository.save(user);
  }

  @GetMapping
  public List<UserEntity> getAllUsers() {
    return userRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable Long id) {

  }
}
