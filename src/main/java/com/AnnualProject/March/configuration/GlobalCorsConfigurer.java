package com.AnnualProject.March.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class GlobalCorsConfigurer {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:8081", "https://xpnnkh6h-8082.uks1.devtunnels.ms/","http://localhost:2025","https://73xd35pq-2025.uks1.devtunnels.ms/","http://localhost:3000","http://localhost:5500"," http://127.0.0.1:5500")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*","Authorization-Mobile")
                        .allowCredentials(true);
            }
        };
    }
}
