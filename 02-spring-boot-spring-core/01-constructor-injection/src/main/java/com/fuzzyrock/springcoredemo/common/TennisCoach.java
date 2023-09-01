package com.fuzzyrock.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TennisCoach implements Coach {
    public TennisCoach() {
        System.out.println("Initialize " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice backhand volley for 10 minutes.";
    }
}
