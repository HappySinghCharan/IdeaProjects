package com.example.jdbc.demo.project.model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping("/")
    public String helloWorld(){
        return "hello dilip";
    }
}
