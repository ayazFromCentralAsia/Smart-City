package com.example.auth_service.dto;


import com.example.auth_service.enumerate.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Модель запроса на регистрацию пользователя")
public class UserRegistrationRequest {

    @Schema(description = "Имя пользователя", example = "john_doe")
    @NotBlank
    private String username;

    @Schema(description = "Email пользователя", example = "john@example.com")
    @Email
    private String email;

    @Schema(description = "Пароль пользователя", example = "password123")
    @NotBlank
    private String password;

    @Schema(description = "Роль пользователя", example = "USER")
    private String role;
}
