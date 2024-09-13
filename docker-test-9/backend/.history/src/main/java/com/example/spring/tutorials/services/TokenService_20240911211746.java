package com.example.spring.tutorials.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.tutorials.models.TokenEntity;
import com.example.spring.tutorials.models.UserEntity;
import com.example.spring.tutorials.repositories.TokenRepository;

import jakarta.transaction.Transactional;

@Service
public class TokenService {

  @Autowired
  private TokenRepository tokenRepository;

  public TokenEntity login(UserEntity user) {
    TokenEntity token = new TokenEntity();

    String uuid = UUID.randomUUID().toString();

    Optional<TokenEntity> existingToken = Optional.of(tokenRepository.findByUser(user));

    if (existingToken.isPresent()) {
      tokenRepository.delete(existingToken.get());
    }

    token.setValue(uuid);
    token.setUser(user);
    token.setExpirationTime(LocalDateTime.now().plusHours(1));

    return tokenRepository.save(token);
  }

  public Optional<TokenEntity> findByValue(String value) {
    return Optional.of(tokenRepository.findByValue(value));
  }

  public Optional<TokenEntity> findByUser(UserEntity user) {
    return Optional.of(tokenRepository.findByUser(user));
  }

  @Transactional
  public void deleteExpiredTokens() {
    LocalDateTime now = LocalDateTime.now();

  }

}
