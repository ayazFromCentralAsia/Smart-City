package com.example.Transport.Service.service;


import com.example.Transport.Service.dto.location.LocationRequest;
import com.example.Transport.Service.model.Location;
import com.example.Transport.Service.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    public String addLocation(LocationRequest location) {
        log.info("Adding location: {}", location);
        Location savedLocation = locationRepository.save(Location.builder()
               .latitude(location.getLatitude())
               .longitude(location.getLongitude())
               .timestamp(location.getTimestamp().toLocalDateTime())
               .speed(location.getSpeed())
               .direction(location.getDirection())
               .build());
        log.info("Location saved with id: {}", savedLocation.getId());
        return "Location saved with id: " + savedLocation.getId();
    }
}
