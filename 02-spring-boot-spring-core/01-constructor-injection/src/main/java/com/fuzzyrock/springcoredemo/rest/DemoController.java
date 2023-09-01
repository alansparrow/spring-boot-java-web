package com.fuzzyrock.springcoredemo.rest;

import com.fuzzyrock.springcoredemo.common.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // Define a private field for the dependency
    private Coach myCoach;

    // Define a constructor for dependency injection
    // @Autowired annotation tells Spring to inject a dependency
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach) {
        System.out.println("Initialize " + getClass().getSimpleName());
        myCoach = theCoach;
    }

    // Define init method
    @PostConstruct
    public void startUp() {
        System.out.println("Starting up...");
    }

    // Define destroy method
    @PreDestroy
    public void destroy() {
        System.out.println("Cleaning up...");
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

}
