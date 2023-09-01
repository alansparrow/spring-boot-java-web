package com.fuzzyrock.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

    public BaseballCoach() {
        System.out.println("Initialize " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice batting for 10 minutes.";
    }
}
