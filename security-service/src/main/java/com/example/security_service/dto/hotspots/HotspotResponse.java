package com.example.security_service.dto.hotspots;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.OffsetDateTime;


@Data
public class HotspotResponse {
    private String type;
    private double latitude;
    private double longitude;
    private int intensity;
}
