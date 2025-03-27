package com.sheslat.historypath.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Allow all endpoints
                        .allowedOrigins("http://localhost:5173") // Add your allowed origins here
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Add allowed HTTP methods
                        .allowedHeaders("*") // Add allowed headers
                        .allowCredentials(true)
                        .maxAge(3600); // Allow cookies (useful for cross-origin sessions)
            }
        };
}

}
