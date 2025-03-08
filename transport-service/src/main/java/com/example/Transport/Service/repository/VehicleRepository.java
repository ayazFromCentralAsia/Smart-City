package com.example.Transport.Service.repository;


import com.example.Transport.Service.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT v FROM Vehicle v " +
            "WHERE (:type IS NULL OR v.type = :#{#type}) " +
            "AND (:status IS NULL OR v.status = :#{#status}) " +
            "AND (:capacity IS NULL OR v.capacity = :capacity) " +
            "AND (:currentLocationId IS NULL OR v.currentLocation.id = :currentLocationId)")
    List<Vehicle> findByFilters(@Param("type") Vehicle.VehicleType type,
                                @Param("status") Vehicle.VehicleStatus status,
                                @Param("capacity") Integer capacity,
                                @Param("currentLocationId") Integer currentLocationId);

    @Query("SELECT v FROM Vehicle v WHERE v.currentRoute.id = :routeId")
    List<Vehicle> findByCurrentRouteId(@Param("routeId") Long routeId);
}
