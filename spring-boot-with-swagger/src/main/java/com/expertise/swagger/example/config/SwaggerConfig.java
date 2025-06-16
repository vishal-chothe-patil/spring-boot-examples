package com.expertise.swagger.example.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("Book API")
                        .description("API documentation for book management.\n\n Developed by KillerExpertise — feel free to reach out. ⚠\uFE0F")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Vishal Chothe")
                                .email("vishalchothe134@gmail.com")
                                .url("https://github.com/vishal-chothe-patil"))
                );
    }
}
