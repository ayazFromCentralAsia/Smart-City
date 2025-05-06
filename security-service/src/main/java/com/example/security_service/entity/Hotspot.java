package com.example.security_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "hotspots")
public class Hotspot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String type;
    private double latitude;
    private double longitude;
    private int intensity;

    @Column(name = "recorded_at")
    private OffsetDateTime recordedAt = OffsetDateTime.now();
}
