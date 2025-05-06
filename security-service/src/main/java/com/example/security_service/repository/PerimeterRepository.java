package com.example.security_service.repository;


import com.example.security_service.entity.Perimeter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerimeterRepository extends JpaRepository<Perimeter, Integer> {
}
