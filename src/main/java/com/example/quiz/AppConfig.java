package com.example.quiz;

import com.example.quiz.app.ShadyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ShadyService shadyService() {
        return ShadyService.builder().build();
    }
}
