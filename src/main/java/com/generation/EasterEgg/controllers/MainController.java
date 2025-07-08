package com.generation.EasterEgg.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
    
@RestController
public class MainController {
    
  @GetMapping("/")
  public String home() {
    return "OK";
  }
}
