package com.example.auth_service.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "Auth Service API", version = "1.0", description = "API for Auth Service"),
        servers = @Server(url = "http://localhost:8081", description = "Auth Service")
)
public class SwaggerConfig {
}

