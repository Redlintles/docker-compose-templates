package com.example.spring.tutorials.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.tutorials.models.TokenEntity;

public interface TokenRepository extends JpaRepository<TokenEntity, Long> {

}
