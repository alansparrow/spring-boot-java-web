package com.fuzzyrock.springcoredemo.rest;

import com.fuzzyrock.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // Define a private field for the dependency
    private Coach myCoach;
    private Coach myCoach1;

    // Define a constructor for dependency injection
    // @Autowired annotation tells Spring to inject a dependency
    @Autowired
    public DemoController(@Qualifier("trackCoach") Coach theCoach,
                          @Qualifier("trackCoach") Coach anotherCoach) {
        System.out.println("Initialize " + getClass().getSimpleName());
        myCoach = theCoach;
        myCoach1 = anotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        System.out.println(myCoach + " " + myCoach1);
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == myCoach1);
    }
}
