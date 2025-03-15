package com.example.Transport.Service.controller;


import com.example.Transport.Service.dto.route.AllRoutesResponse;
import com.example.Transport.Service.dto.route.RouteGetResponse;
import com.example.Transport.Service.dto.route.RouteRequest;
import com.example.Transport.Service.dto.route.VehiclesByRouteResponse;
import com.example.Transport.Service.dto.vehicle.VehicleGetResponse;
import com.example.Transport.Service.dto.vehicle.VehicleLocationResponse;
import com.example.Transport.Service.dto.vehicle.VehicleRequest;
import com.example.Transport.Service.dto.vehicle.VehicleResponse;
import com.example.Transport.Service.service.RouteService;
import com.example.Transport.Service.service.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/transport/route")
@RequiredArgsConstructor
@RestController
@Tag(name = "Transport", description = "Transport API")
public class RouteController {


    private final RouteService routeService;


    @PostMapping("/add")
    @Operation(summary = "Add a new route",
            description = "Add a new route to the system",
            tags = {"Transport API"}
    )
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> addRoute(@RequestBody RouteRequest route, Authentication authentication) {
        System.out.println("User authorities: " + authentication.getAuthorities());
        return ResponseEntity.ok(routeService.addRoute(route));
    }

    @GetMapping("/routes/{id}")
    @Operation(summary = "Get a route by id",
            description = "Get a route by id from the system",
            tags = {"Transport API"}
    )
    public ResponseEntity<RouteGetResponse> getRouteById(Long id) {
        return ResponseEntity.ok(routeService.getRouteById(id));
    }

    @GetMapping("/routes/{id}/vehicles")
    @Operation(summary = "Get vehicles by route id",
            description = "Get all vehicles by route id from the system, IF THEY ARE ASSIGNED TO THE ROUTE",
            tags = {"Transport API"})
    public ResponseEntity<List<VehiclesByRouteResponse>> getVehiclesByRouteId(Long id) {
        return ResponseEntity.ok(routeService.getVehiclesByRouteId(id));
    }

    @GetMapping("/routes")
    @Operation(summary = "Get all routes",
            description = "Get all routes from the system",
            tags = {"Transport API"})
    public ResponseEntity<List<AllRoutesResponse>> getAllRoutes() {
        return ResponseEntity.ok(routeService.getAllRoutes());
    }

}