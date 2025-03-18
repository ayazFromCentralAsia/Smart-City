package com.example.environment_service.repository;

import com.example.environment_service.dto.Responses.AirQualityRecord;
import com.example.environment_service.entity.AirQuality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface AirQualityRepository extends JpaRepository<AirQuality, Long> {

    @Query("""
            SELECT aq FROM AirQuality aq 
            JOIN Station s ON aq.station.id = s.id 
            WHERE (6371 * acos(cos(radians(:latitude)) * cos(radians(s.latitude)) 
            * cos(radians(s.longitude) - radians(:longitude)) 
            + sin(radians(:latitude)) * sin(radians(s.latitude)))) <= :radius 
            ORDER BY (6371 * acos(cos(radians(:latitude)) * cos(radians(s.latitude)) 
            * cos(radians(s.longitude) - radians(:longitude)) 
            + sin(radians(:latitude)) * sin(radians(s.latitude)))) ASC
            """)
    List<AirQuality> findNearestAirQualities(@Param("latitude") double latitude,
                                             @Param("longitude") double longitude,
                                             @Param("radius") double radius);

    @Query("SELECT a FROM AirQuality a WHERE a.station.id = :stationId AND a.timestamp BETWEEN :startTime AND :endTime")
    List<AirQuality> findAirQualityHistory(UUID stationId, LocalDateTime startTime, LocalDateTime endTime);
}