package com.example.micros.companiescrud.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Companies CRUD",
                version = "1.0.0",
                description = "CRUD for managment companies"
        )
)
public class OpenApiConfig {
}
