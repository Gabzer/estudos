package com.aprendendo.first_spring_app.service;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
    public String getHelloMessage(String user) {
        return "Hello, " + user + "!";
    }
}
