package com.example.environment_service.repository;


import com.example.environment_service.entity.NoiseLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NoiseLevelRepository extends JpaRepository<NoiseLevel, Long> {
    @Query("""
    SELECT n FROM NoiseLevel n
    JOIN n.station s
    WHERE function('earth_distance', function('ll_to_earth', s.latitude, s.longitude), function('ll_to_earth', :latitude, :longitude)) <= :radius
    ORDER BY function('earth_distance', function('ll_to_earth', s.latitude, s.longitude), function('ll_to_earth', :latitude, :longitude))
    LIMIT 1
    """)
    NoiseLevel findNearestNoiseLevels(@Param("latitude") double latitude,
                                      @Param("longitude") double longitude,
                                      @Param("radius") double radius);
}
