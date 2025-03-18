package com.example.environment_service.dto.Requests;

import com.example.environment_service.entity.AirQuality;
import com.example.environment_service.entity.Station;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirQualityRequest {

    private Station stationId;

    private Instant timestamp;

    private Double pm25;
    private Double pm10;
    private Double no2;
    private Double so2;
    private Double o3;
    private Double co;
    private Integer aqi;

    private AirQuality.QualityIndex qualityIndex;

    public enum QualityIndex {
        GOOD, MODERATE, UNHEALTHY, HAZARDOUS
    }
}
