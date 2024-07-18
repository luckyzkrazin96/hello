package com.ijse.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello world";
    }

    @GetMapping("/name")
    public String sayName() {
        return "Lakshan";
    }

    @PostMapping("/hello")
    public String createHello() {
        return "Post request to Hello end point";
    }

    @PutMapping("/hello")
    public String udpdateProduct() {
        return "Update request to Hello end point";
    }
}
