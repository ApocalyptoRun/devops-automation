package com.ibrahima.devops.mavenproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @GetMapping("/hello")
    public String helloWorld(){
        return "hello world webhook test";
    }
}
