package com.example.environment_service.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "weather")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "station_id", nullable = false) // Исправлено
    private Station station;

    private LocalDateTime date;

    private Instant timestamp;
    private Double temperature;
    private Double humidity;
    private Double windSpeed;
    private Double windDirection;
    private Double precipitation;
    private String condition;
}
