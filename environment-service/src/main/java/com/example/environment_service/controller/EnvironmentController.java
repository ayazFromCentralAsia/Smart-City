package com.example.environment_service.controller;

import com.example.environment_service.dto.Requests.AirQualityRequest;
import com.example.environment_service.dto.Requests.NoiseLevelRequest;
import com.example.environment_service.dto.Responses.NoiseLevelResponse;
import com.example.environment_service.entity.AirQuality;
import com.example.environment_service.entity.NoiseLevel;
import com.example.environment_service.entity.Weather;
import com.example.environment_service.service.EnvironmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/environment")
@RequiredArgsConstructor
@Tag(name = "Environment", description = "Environmental Data API")
public class EnvironmentController {

    private final EnvironmentService environmentService;

    @PostMapping("/air-quality")
    @Operation(summary = "Add air quality data", description = "Adds new air quality measurements. AIR LEVEL enums 'GOOD', 'MODERATE', 'UNHEALTHY', 'HAZARDOUS'")
    public ResponseEntity<AirQuality> addAirQuality(@RequestBody @Valid AirQualityRequest request) {
        return ResponseEntity.ok(environmentService.addAirQuality(request));
    }

    @PostMapping("/noise-levels")
    @Operation(summary = "Add noise level data", description = "Adds new noise level measurements. NOISE LEVEL enums 'LOW', 'MODERATE', 'HIGH', 'DANGEROUS'")
    public ResponseEntity<NoiseLevelResponse> addNoiseLevel(@RequestBody @Valid NoiseLevelRequest request) {
        return ResponseEntity.ok(environmentService.addNoiseLevel(request));
    }


    @GetMapping("/air-quality")
    @Operation(summary = "Get list of air quality", description = "Retrieve air quality data based on location.")
    public ResponseEntity<List<AirQuality>> getAirQuality(
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam double radius) {
        return ResponseEntity.ok(environmentService.getAirQuality(latitude, longitude, radius));
    }

    @GetMapping("/air-quality/history")
    @Operation(summary = "Get air quality history", description = "Retrieve historical air quality data.")
    public ResponseEntity<List<AirQuality>> getAirQualityHistory(
            @RequestParam UUID stationId,
            @RequestParam LocalDateTime startDate,
            @RequestParam LocalDateTime endDate) {
        return ResponseEntity.ok(environmentService.getAirQualityHistory(stationId, startDate, endDate));
    }

    @GetMapping("/noise-levels")
    @Operation(summary = "Get noise levels", description = "Retrieve noise level data based on location.")
    public ResponseEntity<NoiseLevel> getNoiseLevels(
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam double radius) {
        return ResponseEntity.ok(environmentService.getNoiseLevels(latitude, longitude, radius));
    }

    @GetMapping("/weather")
    @Operation(summary = "Get current weather", description = "Retrieve current weather data based on location.")
    public ResponseEntity<Weather> getWeather(
            @RequestParam double latitude,
            @RequestParam double longitude) {
        return ResponseEntity.ok(environmentService.getWeather(latitude, longitude));
    }



    @GetMapping("/weather/forecast")
    @Operation(summary = "Get weather forecast", description = "Retrieve weather forecast for a given location and number of days.")
    public ResponseEntity<List<Weather>> getWeatherForecast(
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam int days) {
        return ResponseEntity.ok(environmentService.getWeatherForecast(latitude, longitude, days));
    }
}
