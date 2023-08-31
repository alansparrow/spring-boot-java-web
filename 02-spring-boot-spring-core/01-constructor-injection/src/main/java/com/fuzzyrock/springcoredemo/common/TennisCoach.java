package com.fuzzyrock.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice backhand volley for 10 minutes.";
    }
}
