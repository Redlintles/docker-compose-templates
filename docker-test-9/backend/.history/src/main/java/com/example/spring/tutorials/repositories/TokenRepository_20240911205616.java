package com.example.spring.tutorials.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.tutorials.models.TokenEntity;
import com.example.spring.tutorials.models.UserEntity;

public interface TokenRepository extends JpaRepository<TokenEntity, Long> {
  Token findByUser(UserEntity user);

}
