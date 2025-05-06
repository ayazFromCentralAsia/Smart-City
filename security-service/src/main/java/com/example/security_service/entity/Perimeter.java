package com.example.security_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Perimeter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private double latitude;
    private double longitude;
    private int radius;

    @Column(name = "created_at")
    private OffsetDateTime createdAt = OffsetDateTime.now();

    @OneToMany(mappedBy = "perimeter", cascade = CascadeType.ALL)
    private List<Incident> incidents;

    @OneToMany(mappedBy = "perimeter", cascade = CascadeType.ALL)
    private List<Camera> cameras;
}
