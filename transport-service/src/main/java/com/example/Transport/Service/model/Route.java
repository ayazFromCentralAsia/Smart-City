package com.example.Transport.Service.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "routes")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String startPoint;
    private String endPoint;
    private Double distance;
    private Integer averageTime;

    @ManyToMany
    @JoinTable(
            name = "route_stops",
            joinColumns = @JoinColumn(name = "route_id"),
            inverseJoinColumns = @JoinColumn(name = "stop_id")
    )
    private List<Stop> stops;

}