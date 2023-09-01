package com.fuzzyrock.springcoredemo.common;

public class SwimCoach implements Coach {
    public SwimCoach() {
        System.out.println("Initialize " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice swim for 10 minutes.";
    }
}
