package com.hoffmann.betolabets.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Adiciona a configuração de CORS para permitir todas as origens no /login
        registry.addMapping("/v1/login")
                .allowedOrigins("*") // Permite todas as origens, ajuste conforme necessário
                .allowedMethods("POST");
    }
}
