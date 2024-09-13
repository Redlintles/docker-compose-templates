package com.example.spring.tutorials.models;

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
  @JoinColumn(name="id_user" , nullable=false)
  private UserEntity user;


  priva

  public TokenEntity() {
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

    private static class nullable {

        public nullable() {
        }
    }

}
