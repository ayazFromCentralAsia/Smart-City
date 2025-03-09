package com.example.api_gateway;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API Gateway", version = "1.0", description = "Documentation API Gateway v1.0"))
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder
				.routes()
				.route("auth-docs", r -> r.path("/auth-service/**")
						.uri("lb://auth-service"))
				.route("transport-docs", r -> r.path("/transport-service/**")
						.uri("lb://transport-service"))
				.route(r -> r.path("/auth-service/v3/api-docs").and().method(HttpMethod.GET).uri("lb://auth-service"))
				.route(r -> r.path("/transport-service/v3/api-docs").and().method(HttpMethod.GET).uri("lb://transport-service"))
				.build();
	}
}