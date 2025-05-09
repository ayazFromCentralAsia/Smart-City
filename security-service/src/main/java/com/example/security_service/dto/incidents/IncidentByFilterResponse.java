package com.example.security_service.dto.incidents;


import com.example.security_service.entity.Incident;
import com.example.security_service.entity.Perimeter;
import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class IncidentByFilterResponse {
    private String type;

    private Incident.Status status;

    private String description;

    private Integer perimeterId;

    private OffsetDateTime createdAt;
}
