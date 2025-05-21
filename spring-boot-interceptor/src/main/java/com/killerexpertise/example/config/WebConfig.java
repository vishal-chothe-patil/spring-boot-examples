package com.killerexpertise.example.config;

import com.killerexpertise.example.interceptors.LoggingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Changed path pattern to "/**" to intercept all URLs including /hello
        registry.addInterceptor(new LoggingInterceptor())
                .addPathPatterns("/**");
    }
}
