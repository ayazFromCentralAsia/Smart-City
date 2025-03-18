package com.example.environment_service.dto.Requests;

import com.example.environment_service.entity.NoiseLevel;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoiseLevelRequest {

    private UUID stationId;
    private Integer locationId;

    private Instant timestamp;


    private Double decibelLevel;

    @Enumerated(EnumType.STRING)
    private NoiseLevel.Classification classification;

    public enum Classification {
        LOW, MODERATE, HIGH, DANGEROUS
    }
}
