package com.fuzzyrock.restdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/{firstName}/{lastName}")
    public String sayHello(@PathVariable String firstName, @PathVariable String lastName) {
        return firstName + " " + lastName;
    }
}
