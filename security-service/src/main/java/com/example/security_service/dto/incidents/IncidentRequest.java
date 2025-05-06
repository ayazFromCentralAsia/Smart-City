package com.example.security_service.dto.incidents;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "ДТО для создания инцидента")
@Data
public class IncidentRequest {
    @Schema(description = "Тип инцидента", example = "Дорожная авария")
    private String type;
    @Schema(description = "Статус инцидента", example = "OPEN")
    private String status;
    @Schema(description = "Описание инцидента", example = "Водитель не может двигаться")
    private String description;
    @Schema(description = "ID периметра, к которому относится инцидент", example = "1")
    private Integer perimeterId;
}