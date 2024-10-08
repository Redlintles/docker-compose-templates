package com.example.spring.tutorials.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserEntity {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique= true)
  private String username;
  @Column(nullable = false, unique=true)
  private String email;
  @Column(nullable = false)
  private String password;
  @Column(nullable = false)
  private String phoneNumber;

  public UserEntity() {}

  public UserEntity(String username, String email, String password, String phoneNumber) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.phoneNumber = phoneNumber;

  }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
