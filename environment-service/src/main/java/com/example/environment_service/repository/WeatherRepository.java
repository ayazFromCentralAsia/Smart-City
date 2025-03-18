package com.example.environment_service.repository;

import com.example.environment_service.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {
    @Query("""
            SELECT w FROM Weather w
            JOIN w.station s
            ORDER BY function('earth_distance', function('ll_to_earth', s.latitude, s.longitude), function('ll_to_earth', :latitude, :longitude))
            LIMIT 1
            """)
    Weather findNearestWeather(@Param("latitude") double latitude,
                               @Param("longitude") double longitude);

    @Query("SELECT w FROM Weather w JOIN w.station s WHERE w.timestamp >= CURRENT_TIMESTAMP AND w.timestamp < :endDate ORDER BY function('earth_distance', function('ll_to_earth', s.latitude, s.longitude), function('ll_to_earth', :latitude, :longitude)), w.timestamp")
    List<Weather> findWeatherForecast(@Param("latitude") double latitude, @Param("longitude") double longitude, @Param("endDate") int endDate);
}
