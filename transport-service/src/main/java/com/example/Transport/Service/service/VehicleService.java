package com.example.Transport.Service.service;

import com.example.Transport.Service.dto.vehicle.VehicleGetResponse;
import com.example.Transport.Service.dto.vehicle.VehicleLocationResponse;
import com.example.Transport.Service.dto.vehicle.VehicleRequest;
import com.example.Transport.Service.dto.vehicle.VehicleResponse;
import com.example.Transport.Service.mapper.VehicleMapper;
import com.example.Transport.Service.model.Location;
import com.example.Transport.Service.model.Route;
import com.example.Transport.Service.model.Vehicle;
import com.example.Transport.Service.repository.LocationRepository;
import com.example.Transport.Service.repository.RouteRepository;
import com.example.Transport.Service.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final LocationRepository locationRepository;
    private final RouteRepository routeRepository;
    private final VehicleMapper vehicleMapper;

    @Transactional
    public String addVehicle(VehicleRequest vehicle) {
        Location currentLocation = locationRepository.findById(vehicle.getCurrentLocationId()).orElseThrow(()
                -> new IllegalArgumentException("Invalid location id"));
        Route currentRoute = routeRepository.findById(vehicle.getCurrentRouteId()).orElseThrow(()
                -> new IllegalArgumentException("Invalid route id"));
        Vehicle newVehicle = Vehicle.builder()
                .type(Vehicle.VehicleType.valueOf(vehicle.getType().toUpperCase()))
                .registrationNumber(vehicle.getRegistrationNumber())
                .capacity(vehicle.getCapacity())
                .status(Vehicle.VehicleStatus.valueOf(vehicle.getStatus().toUpperCase()))
                .currentLocation(currentLocation)
                .currentRoute(currentRoute)
                .build();

        vehicleRepository.save(newVehicle);
        return "Vehicle added successfully";
    }

    public List<VehicleResponse> getAllVehicles(String typeStr,
                                                String statusStr,
                                                Integer capacity,
                                                Integer currentLocationId) {
        Vehicle.VehicleType type = null;
        if (typeStr != null && !typeStr.isEmpty()) {
            try {
                type = Vehicle.VehicleType.valueOf(typeStr.toUpperCase());
            } catch (IllegalArgumentException e) {
                log.warn("Invalid vehicle type: {}", typeStr);
            }
        }

        Vehicle.VehicleStatus status = null;
        if (statusStr != null && !statusStr.isEmpty()) {
            try {
                status = Vehicle.VehicleStatus.valueOf(statusStr.toUpperCase());
            } catch (IllegalArgumentException e) {
                log.warn("Invalid vehicle status: {}", statusStr);
            }
        }

        List<Vehicle> vehicles = vehicleRepository.findByFilters(type, status, capacity, currentLocationId);
        return vehicleMapper.vehiclesToVehicleResponses(vehicles);
    }

    public VehicleGetResponse getVehicleById(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("Invalid vehicle id"));
        return vehicleMapper.vehicleToVehicleGetResponse(vehicle);
    }

    public VehicleLocationResponse getVehicleLocation(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("Invalid vehicle id"));
        Location currentLocation = vehicle.getCurrentLocation();
        return VehicleLocationResponse.builder()
               .type(vehicle.getType().toString())
               .registrationNumber(vehicle.getRegistrationNumber())
               .status(vehicle.getStatus().toString())
                .latitude(currentLocation.getLatitude())
               .longitude(currentLocation.getLongitude())
               .direction(currentLocation.getDirection())
               .build();
    }
}