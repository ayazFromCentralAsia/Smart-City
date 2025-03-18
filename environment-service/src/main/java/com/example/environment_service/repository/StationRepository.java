package com.example.environment_service.repository;

import com.example.environment_service.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface StationRepository extends JpaRepository<Station, UUID> {
}
