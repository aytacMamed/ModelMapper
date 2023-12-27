package com.changeside.persondto.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@OpenAPIDefinition
public class SpringDocumentationConfig {
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI().info(
                new Info().
                        title("Aytac Mammadli terefinden dokumentasiya").
                        version("1.0.0").
                        description("person managment site ").
                        contact(
                                new Contact().url("www.google.com").
                                        email("example@gmail.com").
                                        name("Aytac Mammadli")
                        )

        );
    }
}
