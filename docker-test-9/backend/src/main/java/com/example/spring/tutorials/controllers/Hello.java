package com.example.spring.tutorials.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.tutorials.models.SanityCheck;

@RestController()
@RequestMapping("/sanityCheck")
public class Hello {

  @Value("${app.name}")
  private String appValue;

  @GetMapping()
  public SanityCheck sanityCheck() {
    return new SanityCheck("Server " + appValue + " is running!", 200);
  }
}
