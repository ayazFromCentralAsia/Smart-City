package com.example.Transport.Service.controller;


import com.example.Transport.Service.dto.transport.ScheduleResponse;
import com.example.Transport.Service.dto.transport.StopRequest;
import com.example.Transport.Service.service.LocationService;
import com.example.Transport.Service.service.TransportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/api/transport")
@RequiredArgsConstructor
@RestController
@Tag(name = "Transport", description = "Transport API")
public class TransportController {

    private final TransportService transportService;
    private final LocationService locationService;


    @GetMapping("/schedules")
    @Operation(summary = "Get schedules",
            description = "Get schedules for a route on a given date",
            tags = {"Transport API"})
    public List<ScheduleResponse> getSchedules(Long routeId, LocalDate date) {
        return transportService.getSchedules(routeId, date);
    }

    @PostMapping("/add-stop")
    @Operation(summary = "Add new stop to the route",
            description = "Add new stop to the route with the given name and location. ",
            tags = {"Transport API"})
    public ResponseEntity<String> addStop(@RequestBody StopRequest stopRequest) {
        return ResponseEntity.ok(transportService.addStop(stopRequest));
    }

}