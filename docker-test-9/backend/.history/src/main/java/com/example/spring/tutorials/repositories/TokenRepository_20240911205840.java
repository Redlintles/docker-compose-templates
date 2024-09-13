package com.example.spring.tutorials.repositories;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.tutorials.models.TokenEntity;
import com.example.spring.tutorials.models.UserEntity;

public interface TokenRepository extends JpaRepository<TokenEntity, Long> {
  TokenEntity findByUser(UserEntity user);

  void deleteByExpirationTimeBefore(LocalDateTime dateTime);
}
