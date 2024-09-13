package com.example.spring.tutorials.models;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class TokenEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  public Long getId() {
    return id;
  }

  private String value;

  @OneToOne
  @JoinColumn(name = "id_user", nullable = false)
  private UserEntity user;

  private LocalDateTime expirationTime;

  public TokenEntity() {
  }

  public TokenEntity(LocalDateTime expirationTime, Long id, UserEntity user, String value) {
    this.expirationTime = expirationTime;
    this.id = id;
    this.user = user;
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public LocalDateTime getExpirationTime() {
    return expirationTime;
  }

  public void setExpirationTime(LocalDateTime expirationTime) {
    this.expirationTime = expirationTime;
  }

  public UserEntity getUser() {
    return user;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }

}
