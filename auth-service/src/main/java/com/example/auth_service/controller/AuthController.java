package com.example.auth_service.controller;

import com.example.auth_service.dto.UserRegistrationRequest;
import com.example.auth_service.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.representations.AccessTokenResponse;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Auth", description = "Authentication API")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    @Operation(summary = "Register a new user",
            description = "Register a new user with the given username, email, password, and role. Role must be either 'USER', 'OPERATOR' or 'ADMIN'. ",
            tags = {"Authentication API"}
    )
    public ResponseEntity<String> register(UserRegistrationRequest user) {
        return ResponseEntity.ok(authService.register(user));
    }

    @PostMapping("/login")
    @Operation(summary = "Login a user",
            description = "Login a user with the given username and password. Returns an access token that can be used for subsequent requests.",
            tags = {"Authentication API"}
    )
    public ResponseEntity<String> login(String username, String password) {
        return ResponseEntity.ok(authService.login(username, password));
    }

    @PostMapping("/user-info")
    @Operation(summary = "Get user information",
            description = "Get user information with the given access token. Returns the user information in JSON format.",
            tags = {"Authentication API"}
    )
    public ResponseEntity<String> getUserInfo(@Parameter(description = "Access token of the user") @RequestParam(value = "access_token", required = true) String accessToken) {
        return ResponseEntity.ok(authService.getUserInfo(accessToken));
    }

    @PostMapping("/change-user-info")
    @Operation(summary = "Change user information",
            description = "Change user information with the given access token and user information. Returns a message indicating whether the operation was successful or not.",
            tags = {"Authentication API"}
    )
    public ResponseEntity<String> changeUserInformation(@Parameter(description = "Access token of the user") @RequestParam(value = "access_token", required = true) String accessToken,
                                                        @Parameter(description = "User information to be changed") @RequestParam(value = "user", required = true) @Schema(implementation = UserRegistrationRequest.class) UserRegistrationRequest user) {
        return ResponseEntity.ok(authService.changeUserInformation(accessToken, user));
    }

    @PostMapping("/reset-password")
    @Operation(summary = "Reset password",
            description = "Reset password with the given username and new password. Returns a message indicating whether the operation was successful or not.",
            tags = {"Authentication API"}
    )
    public ResponseEntity<String> resetPassword(
            @Parameter(description = "Username of the user to reset password") @RequestParam( value = "username", required = true) String username,
            @Parameter(description = "New password of the user") @RequestParam( value = "credential", required = true) String password) {
        return ResponseEntity.ok(authService.resetPassword(username, password));
    }
}