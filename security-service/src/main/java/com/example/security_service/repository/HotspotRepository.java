package com.example.security_service.repository;

import com.example.security_service.entity.Hotspot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface HotspotRepository extends JpaRepository<Hotspot, Integer> {
    @Query("SELECT h FROM Hotspot h WHERE h.recordedAt BETWEEN :from AND :to")
    List<Hotspot> findByTime(@Param("from") ZonedDateTime from, @Param("to") ZonedDateTime to);}
