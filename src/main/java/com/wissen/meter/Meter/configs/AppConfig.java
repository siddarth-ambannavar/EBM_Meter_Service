package com.wissen.meter.Meter.configs;

import com.wissen.meter.Meter.implementations.UsageGenerationTask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public UsageGenerationTask generationTask(){
        return new UsageGenerationTask();
    }
}
