package com.example.environment_service.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "noise_level")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoiseLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "station_id", nullable = false) // Исправлено
    private Station station;

    private Instant timestamp;
    private Double decibelLevel;

    @Enumerated(EnumType.STRING)
    private Classification classification;

    public enum Classification {
        LOW, MODERATE, HIGH, DANGEROUS
    }
}