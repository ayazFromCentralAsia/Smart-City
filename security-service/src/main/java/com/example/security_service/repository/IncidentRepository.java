package com.example.security_service.repository;

import com.example.security_service.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Integer> {
    List<Incident> findByStatusAndType(Incident.Status status, String type);
}
