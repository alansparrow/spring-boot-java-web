package com.fuzzyrock.springboot.demo.HelloWorld.rest;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    // Inject props
    @Value("${cat.name1}")
    private String cat1;

    @Value("${cat.name2}")
    private String cat2;

    // Expose a new endpoints for "cats"
    @GetMapping("/cats")
    public String getCats() {
        return cat1 + " & " + cat2;
    }

    // Expose "/" that returns "Hello World"
    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }

    // Expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }

    // Expose a new endpoint for "fortune"
    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "You are lucky!";
    }
}
