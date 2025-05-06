package com.example.security_service.repository;

import com.example.security_service.entity.Hotspot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotspotRepository extends JpaRepository<Hotspot, Integer> {
}
