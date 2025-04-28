package com.example.Transport.Service.service;

import com.example.Transport.Service.dto.transport.ScheduleResponse;
import com.example.Transport.Service.dto.transport.StopRequest;
import com.example.Transport.Service.model.Location;
import com.example.Transport.Service.model.Route;
import com.example.Transport.Service.model.Stop;
import com.example.Transport.Service.model.Vehicle;
import com.example.Transport.Service.repository.LocationRepository;
import com.example.Transport.Service.repository.RouteRepository;
import com.example.Transport.Service.repository.StopRepository;
import com.example.Transport.Service.repository.VehicleRepository;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class TransportService {

    private final LocationRepository transportRepository;
    private final RouteRepository routeRepository;
    private final VehicleRepository vehicleRepository;
    private final StopRepository stopRepository;

    public List<ScheduleResponse> getSchedules(Long routeId, LocalDate date) {
        log.info("Getting schedules for routeId: {}, date: {}", routeId, date);
        Route route = routeRepository.findById(routeId).orElseThrow(()
                -> new IllegalArgumentException("Invalid route id"));
        List<Vehicle> vehicles = vehicleRepository.findByCurrentRouteId(routeId);

        ScheduleResponse response = ScheduleResponse.builder()
                .routeName(route.getName())
                .vehicles(vehicles.stream().map(Vehicle::getId).toList())
                .stops(route.getStops().stream().map(Stop::getId).toList())
                .date(date)
                .build();
        return List.of(response);
    }

    public String addStop(StopRequest stopRequest) {
        log.info("Adding stop: {}", stopRequest);
        Stop stop = Stop.builder()
               .name(stopRequest.getName())
               .location(transportRepository.findById(stopRequest.getLocationId()).orElseThrow(()
                        -> new IllegalArgumentException("Invalid location id")))
               .facilities(stopRequest.getFacilities())
               .build();
        stopRepository.save(stop);
        return "Stop added successfully";
    }
}