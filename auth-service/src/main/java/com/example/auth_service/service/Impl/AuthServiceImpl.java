package com.example.auth_service.service.Impl;

import com.example.auth_service.dto.UserRegistrationRequest;
import com.example.auth_service.service.AuthService;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.representations.AccessTokenResponse;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final Keycloak keycloak;

    @Value("${keycloak.realm-name}")
    private String realmName;

    @Value("${keycloak.client-id}")
    private String clientId;

    @Value("${keycloak.client-secret}")
    private String clientSecret;

    @Override
    public String register(UserRegistrationRequest userDto) {
        RealmResource realm = keycloak.realm(realmName);

        UserRepresentation user = new UserRepresentation();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setEnabled(true);
        user.setCredentials(Collections.singletonList(createPasswordCredential(userDto.getPassword())));
        user.setRealmRoles(Collections.singletonList(String.valueOf(userDto.getRole())));

        Response response = realm.users().create(user);
        if (response.getStatus() != 201) {
            throw new RuntimeException("Failed to create user");
        }

        return login(userDto.getUsername(), userDto.getPassword());
    }

    public String login(String username, String password) {
        Keycloak keycloakLogin = KeycloakBuilder.builder()
                .serverUrl("http://localhost:8181")
                .realm(realmName)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .grantType(OAuth2Constants.PASSWORD)
                .username(username)
                .password(password)
                .build();

        AccessTokenResponse tokenResponse = keycloakLogin.tokenManager().getAccessToken();
        return tokenResponse.getToken();
    }

    @Override
    public String getUserInfo(String accessToken) {
        RealmResource realm = keycloak.realm(realmName);

        return realm.users().search(accessToken).get(0).toString();
    }

    @Override
    public String changeUserInformation(String accessToken, UserRegistrationRequest user) {
        RealmResource realm = keycloak.realm(realmName);

        UserRepresentation userRepresentation = realm.users().search(accessToken).get(0);
        userRepresentation.setUsername(user.getUsername());
        userRepresentation.setEmail(user.getEmail());
        userRepresentation.setRealmRoles(Collections.singletonList(String.valueOf(user.getRole())));
        realm.users().get(userRepresentation.getId()).update(userRepresentation);

        return "User information updated successfully";
    }

    @Override
    public String resetPassword(String username, String password) {
        RealmResource realm = keycloak.realm(realmName);

        UserRepresentation user = realm.users().search(username).get(0);
        CredentialRepresentation passwordCred = createPasswordCredential(password);
        user.setCredentials(Collections.singletonList(passwordCred));
        realm.users().get(user.getId()).update(user);

        return "Password reset successfully";
    }


    private CredentialRepresentation createPasswordCredential(String password) {
        CredentialRepresentation passwordCred = new CredentialRepresentation();
        passwordCred.setTemporary(false);
        passwordCred.setType(CredentialRepresentation.PASSWORD);
        passwordCred.setValue(password);
        return passwordCred;
    }
}
