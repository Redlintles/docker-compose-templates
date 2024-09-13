package com.example.spring.tutorials.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.tutorials.models.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
  UserEntity findByUsername(String username);

  UserEntity findByEmail(String email);
}
