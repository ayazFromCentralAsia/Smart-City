package com.example.auth_service.service;

import com.example.auth_service.dto.UserRegistrationRequest;
import org.keycloak.representations.idm.CredentialRepresentation;

public interface AuthService {
    String register(UserRegistrationRequest user);
    String login(String username, String password);
    String getUserInfo(String accessToken);
    String changeUserInformation(String accessToken, UserRegistrationRequest user);
    String resetPassword(String username, String password);
}
