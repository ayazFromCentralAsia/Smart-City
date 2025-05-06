package com.example.security_service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "cameras")
public class Camera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String zone;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "stream_url")
    private String streamUrl;

    @ManyToOne
    @JoinColumn(name = "perimeter_id")
    private Perimeter perimeter;

    public enum Status {
        ONLINE, OFFLINE, MAINTENANCE
    }
}
