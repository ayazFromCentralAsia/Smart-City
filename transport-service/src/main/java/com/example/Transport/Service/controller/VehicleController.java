package com.example.Transport.Service.controller;


import com.example.Transport.Service.dto.vehicle.VehicleGetResponse;
import com.example.Transport.Service.dto.vehicle.VehicleLocationResponse;
import com.example.Transport.Service.dto.vehicle.VehicleRequest;
import com.example.Transport.Service.dto.vehicle.VehicleResponse;
import com.example.Transport.Service.service.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/transport/vehicle")
@RequiredArgsConstructor
@RestController
@Tag(name = "Transport", description = "Transport API")
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping("/add")
    @Operation(summary = "Add a new vehicle",
            description = "This API is used to add a new vehicle to the system, needs to use types like BUS, TRAM, TROLLEY, " +
                    "it is same for status like ACTIVE, MAINTENANCE, OUT_OF_SERVICE",
            tags = {"Transport API"}
    )
    @PreAuthorize("hasRole('OPERATOR')")
    public ResponseEntity<String> addVehicle(@RequestBody @Valid VehicleRequest vehicle) {
        return ResponseEntity.ok(vehicleService.addVehicle(vehicle));
    }

    @GetMapping("/get-all")
    @Operation(summary = "Get all vehicles",
            description = "This API is used to get all vehicles from the system, it can filter by type, status, capacity, current location ID",
            tags = {"Transport API"}
    )
    @PreAuthorize("hasRole('OPERATOR')")
    public ResponseEntity<List<VehicleResponse>> getAllVehicles(
            @Parameter(description = "Type of transport vehicle, BUS, TRAM, TROLLEY", example = "BUS") @RequestParam(required = false) String type,
            @Parameter(description = "Status of the transport vehicle, ACTIVE, MAINTENANCE, OUT_OF_SERVICE", example = "ACTIVE") @RequestParam(required = false) String status,
            @Parameter(description = "Capacity of the transport vehicle", example = "20") @RequestParam(required = false) Integer capacity,
            @Parameter(description = "ID of the current location of the transport vehicle", example = "1") @RequestParam(required = false) Integer currentLocationId) {
        return ResponseEntity.ok(vehicleService.getAllVehicles(type, status, capacity, currentLocationId));
    }


    @GetMapping("/vehicles/{id}")
    @Operation(summary = "Get a vehicle by ID",
            description = "This API is used to get a vehicle by ID from the system",
            tags = {"Transport API"}
    )
    @PreAuthorize("hasRole('OPERATOR')")
    public ResponseEntity<VehicleGetResponse> getVehicleById(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }

    @GetMapping("/vehicles/{id}/location")
    @Operation(summary = "Get a vehicle's location by ID",
            description = "This API is used to get a vehicle's location by ID from the system",
            tags = {"Transport API"}
    )
    @PreAuthorize("hasRole('OPERATOR')")
    public VehicleLocationResponse getVehicleLocation(@PathVariable Long id) {
        return vehicleService.getVehicleLocation(id);
    }
}