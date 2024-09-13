package com.example.spring.tutorials.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.tutorials.dtos.CreateUserDTO;
import com.example.spring.tutorials.dtos.UpdateUserDTO;
import com.example.spring.tutorials.dtos.UserLoginDTO;
import com.example.spring.tutorials.models.UserEntity;
import com.example.spring.tutorials.repositories.UserRepository;
import com.example.spring.tutorials.services.TokenService;

import jakarta.validation.Valid;

@RequestMapping("/users")
@RestController()
public class User {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private TokenService tokenService;

  @PostMapping
  public UserEntity createUser(@Valid @RequestBody CreateUserDTO userData) {

    UserEntity user = new UserEntity();

    user.setUsername(userData.getUsername());
    user.setEmail(userData.getEmail());
    user.setPassword(userData.getPassword());
    user.setPhoneNumber(userData.getPhoneNumber());
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

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteUser(@PathVariable Long id) {
    return userRepository.findById(id).map(user -> {
      userRepository.delete(user);
      return ResponseEntity.ok(user);
    }).orElse(ResponseEntity.notFound().build());
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@Valid @RequestBody UserLoginDTO userLoginDTO) {
    Optional<UserEntity> user = Optional.of(userRepository.findByEmail(userLoginDTO.getEmail()));

    if (user.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    if (!user.get().getPassword().equals(userLoginDTO.getPassword())) {
      return new ResponseEntity<>("Email or password are incorrect", HttpStatus.UNAUTHORIZED);
    }

  }
}
