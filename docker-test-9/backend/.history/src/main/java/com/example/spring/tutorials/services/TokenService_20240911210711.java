package com.example.spring.tutorials.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.tutorials.models.TokenEntity;
import com.example.spring.tutorials.models.UserEntity;
import com.example.spring.tutorials.repositories.TokenRepository;
import com.example.spring.tutorials.repositories.UserRepository;

@Service
public class TokenService {

  @Autowired
  private TokenRepository tokenRepository;
  @Autowired
  private UserRepository userRepository;

  public TokenEntity login(UserEntity user) {

  }

}
