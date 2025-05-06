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
@Table(name = "incidents")
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String type;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String description;

    @ManyToOne
    @JoinColumn(name = "perimeter_id")
    private Perimeter perimeter;

    @Column(name = "created_at")
    private OffsetDateTime createdAt = OffsetDateTime.now();

    public enum Status {
        OPEN, IN_PROGRESS, RESOLVED
    }
}
