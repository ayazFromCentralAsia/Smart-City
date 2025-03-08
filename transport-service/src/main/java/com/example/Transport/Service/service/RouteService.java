package com.example.Transport.Service.service;


import com.example.Transport.Service.dto.route.AllRoutesResponse;
import com.example.Transport.Service.dto.route.RouteGetResponse;
import com.example.Transport.Service.dto.route.RouteRequest;
import com.example.Transport.Service.dto.route.VehiclesByRouteResponse;
import com.example.Transport.Service.dto.vehicle.VehicleResponse;
import com.example.Transport.Service.exceptions.NotFoundException;
import com.example.Transport.Service.mapper.RouteMapper;
import com.example.Transport.Service.model.Route;
import com.example.Transport.Service.model.Vehicle;
import com.example.Transport.Service.repository.LocationRepository;
import com.example.Transport.Service.repository.RouteRepository;
import com.example.Transport.Service.repository.StopRepository;
import com.example.Transport.Service.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository routeRepository;
    private final StopRepository stopService;
    private final LocationRepository locationRepository;
    private final VehicleRepository vehicleRepository;
    private final RouteMapper routeMapper;

    public String addRoute(RouteRequest routeRequest) {
        log.info("Adding new route");
        Route route = Route.builder()
                .name(routeRequest.getName())
                .startPoint(routeRequest.getStartPoint())
                .endPoint(routeRequest.getEndPoint())
                .distance(routeRequest.getDistance())
                .averageTime(routeRequest.getAverageTime())
                .build();

        routeRepository.save(route);
        log.info("Route added successfully");
        return "Route added successfully";
    }

    public RouteGetResponse getRouteById(long id) {
        log.info("Getting route by id");
        Route route = routeRepository.findById(id).orElseThrow(() -> new NotFoundException("Route not found"));
        log.info("Route found successfully");
        return routeMapper.mapToRouteGetResponse(route);
    }

    public List<VehiclesByRouteResponse> getVehiclesByRouteId(Long id) {
        log.info("Getting vehicles by route id");
        Route route = routeRepository.findById(id).orElseThrow(() -> new NotFoundException("Route not found"));
        List<Vehicle> vehicles = vehicleRepository.findByCurrentRouteId(id);
        if (vehicles.isEmpty()){
            log.info("No vehicles found for this route");
            throw new NotFoundException("No vehicles found for this route");
        }
        log.info("Vehicles found successfully");
        List<VehiclesByRouteResponse> vehiclesByRouteResponseList = vehicles.stream()
               .map(v -> VehiclesByRouteResponse.builder()
                       .name(route.getName())
                       .startPoint(route.getStartPoint())
                       .endPoint(route.getEndPoint())
                       .distance(route.getDistance())
                       .averageTime(route.getAverageTime())
                       .vehicles(List.of(VehicleResponse.builder()
                               .type(v.getType().toString())
                              .registrationNumber(v.getRegistrationNumber())
                               .capacity(v.getCapacity())
                               .status(v.getStatus().toString())
                               .build()))
                       .build())
               .toList();
        log.info("Vehicles by route id found successfully");
        return vehiclesByRouteResponseList;
    }

    public List<AllRoutesResponse> getAllRoutes() {
        log.info("Getting all routes");
        List<Route> routes = routeRepository.findAll();
        if (routes.isEmpty()){
            log.info("No routes found");
            throw new NotFoundException("No routes found");
        }
        log.info("Routes found successfully");
        List<AllRoutesResponse> allRoutesResponseList = routes.stream()
               .map(r -> AllRoutesResponse.builder()
                       .name(r.getName())
                       .startPoint(r.getStartPoint())
                       .endPoint(r.getEndPoint())
                       .distance(r.getDistance())
                       .averageTime(r.getAverageTime())
                       .build())
               .toList();
        log.info("All routes found successfully");
        return allRoutesResponseList;
    }
}
