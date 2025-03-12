package com.example.Transport.Service.repository;

import com.example.Transport.Service.model.Stop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StopRepository extends JpaRepository<Stop, Long> {
    List<Stop> findAllByLocationId(Long id);
}
