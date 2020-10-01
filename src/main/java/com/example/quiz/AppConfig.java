package com.example.quiz;

import com.example.quiz.app.generateTestDataService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public generateTestDataService shadyService() {
        return generateTestDataService.builder().build();
    }
}
