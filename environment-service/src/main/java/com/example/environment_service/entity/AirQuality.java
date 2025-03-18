package com.example.environment_service.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "air_quality")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AirQuality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "station_id", nullable = false)
    private Station station;

    private Instant timestamp;

    private Double pm25;
    private Double pm10;
    private Double no2;
    private Double so2;
    private Double o3;
    private Double co;
    private Integer aqi;

    @Enumerated(EnumType.STRING)
    @Column(name = "quality_index")
    private QualityIndex qualityIndex;

    public enum QualityIndex {
        GOOD, MODERATE, UNHEALTHY, HAZARDOUS
    }
}
