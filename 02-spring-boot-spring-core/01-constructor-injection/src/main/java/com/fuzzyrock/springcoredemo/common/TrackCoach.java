package com.fuzzyrock.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {
    public TrackCoach() {
        System.out.println("Initialize " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice run for 10 minutes.";
    }
}
