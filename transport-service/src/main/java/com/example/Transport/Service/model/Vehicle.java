package com.example.Transport.Service.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "vehicles")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private VehicleType type;

    private String registrationNumber;
    private Integer capacity;

    @Enumerated(EnumType.STRING)
    private VehicleStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "current_location_id")
    private Location currentLocation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "current_route_id")
    private Route currentRoute;


    public enum VehicleType {
        BUS, TRAM, TROLLEY
    }

    public enum VehicleStatus {
        ACTIVE, MAINTENANCE, OUT_OF_SERVICE
    }
}
