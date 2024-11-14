package com.hoffmann.betolabets.config;

import com.hoffmann.betolabets.infra.JwtClaimResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final JwtClaimResolver jwtClaimResolver;

    public WebConfig(JwtClaimResolver jwtClaimResolver) {
        this.jwtClaimResolver = jwtClaimResolver;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(jwtClaimResolver);
    }
}

