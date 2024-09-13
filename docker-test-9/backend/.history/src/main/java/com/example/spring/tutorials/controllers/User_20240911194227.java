package com.example.spring.tutorials.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.tutorials.dtos.UpdateUserDTO;
import com.example.spring.tutorials.models.UserEntity;
import com.example.spring.tutorials.repositories.UserRepository;

import jakarta.validation.Valid;

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
  public ResponseEntity<?> getUserById(@PathVariable Long id) {
    return userRepository.findById(id).map(user -> ResponseEntity.ok(user)).orElse(ResponseEntity.notFound().build());
  }

  @PatchMapping("/{id}")
  public ResponseEntity<?> updateUser(@PathVariable Long id, @Valid @RequestBody UpdateUserDTO userData) {
    Optional<UserEntity> optionalUser = userRepository.findById(id);

    if (optionalUser.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    UserEntity user = optionalUser.get();

    if (userData.getUsername() != null) {
      user.setUsername(userData.getUsername());
    }

    if (userData.getEmail() != null) {
      user.setEmail(userData.getEmail());
    }
    if (userData.getPassword() != null) {
      user.setPassword(userData.getPassword());
    }
    if (userData.getPhoneNumber() != null) {
      user.setPhoneNumber(userData.getPhoneNumber());
    }

    userRepository.save(user);

    return ResponseEntity.ok(user);
  }

}
