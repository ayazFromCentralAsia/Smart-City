package com.example.security_service.repository;

import com.example.security_service.entity.Camera;
import com.example.security_service.enums.CamerasStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CameraRepository extends JpaRepository<Camera, Integer> {


    @Query("""
        SELECT c FROM Camera c
        WHERE (:zone IS NULL OR c.zone = :zone)
          AND (:status IS NULL OR c.status = :status)
          AND (:perimeterId IS NULL OR c.perimeter.id = :perimeterId)
        """)
    List<Camera> findByFilter(@Param("zone") String zone,
                              @Param("status") Camera.Status status,
                              @Param("perimeterId") Integer perimeterId);
}
