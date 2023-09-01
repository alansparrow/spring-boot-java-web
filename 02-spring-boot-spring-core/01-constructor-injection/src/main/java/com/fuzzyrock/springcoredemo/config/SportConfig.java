package com.fuzzyrock.springcoredemo.config;

import com.fuzzyrock.springcoredemo.common.Coach;
import com.fuzzyrock.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    // Method's name is used in @Qualifier
    @Bean
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
