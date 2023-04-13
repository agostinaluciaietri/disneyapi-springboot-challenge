package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class IndexController {
/*
    @GetMapping()
    public String hello() {
        return "Hello Spring Boot";
    }

    @GetMapping("/test")
    public String test() {
        return "Test Spring Boot";
    }
*/
    @GetMapping()
    public String get() {
        return "Disney movies API";
    }
/*
    @PostMapping("/login")
    public String login(@RequestParam("login") String login, @RequestParam("senha") String senha) {
        return "Login: " + login + ", password: " + senha;
    }


    @PostMapping()
    public String post() {
        return "Post Spring Boot";
    }

    @PutMapping()
    public String put() {
        return "Put Spring Boot";
    }

    @DeleteMapping()
    public String delete() {
        return "Delete Spring Boot";
    }
*/
}
