package com.example.spring.tutorials.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/sanityCheck")
public class Hello {
  @GetMapping()
  public String sanityCheck() {
    return "Everything is Working";
  }
}
