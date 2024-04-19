package com.example.car.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Car Management"
                ),
                description = "OpenApi documentation for Frontend",
                title = "Car Project Api",
                version = "1.0",
                termsOfService = "Terms of Service"
        )
)
public class OpenApiConfig {
}
