package com.example.Transport.Service.controller;


import com.example.Transport.Service.dto.location.LocationRequest;
import com.example.Transport.Service.service.LocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/transport/location")
@RequiredArgsConstructor
@RestController
@Tag(name = "Transport", description = "Transport API")
public class LocationController {

    private final LocationService locationService;

    @PostMapping("/add")
    @Operation(summary = "Add a new location",
            description = "Add a new location to the system",
            tags = {"Transport API"}
    )
    @PreAuthorize("hasRole('OPERATOR')")
    public ResponseEntity<String> addLocation(@RequestBody LocationRequest location) {
        return ResponseEntity.ok(locationService.addLocation(location));
    }
}
