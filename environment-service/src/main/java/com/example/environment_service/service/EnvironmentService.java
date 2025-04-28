package com.example.environment_service.service;

import com.example.environment_service.dto.Requests.AirQualityRequest;
import com.example.environment_service.dto.Requests.NoiseLevelRequest;
import com.example.environment_service.dto.Responses.NoiseLevelResponse;
import com.example.environment_service.entity.AirQuality;
import com.example.environment_service.entity.NoiseLevel;
import com.example.environment_service.entity.Station;
import com.example.environment_service.entity.Weather;
import com.example.environment_service.mapper.AirQualityMapper;
import com.example.environment_service.mapper.NoiseLevelMapper;
import com.example.environment_service.models.VehicleResponse;
import com.example.environment_service.repository.AirQualityRepository;
import com.example.environment_service.repository.NoiseLevelRepository;
import com.example.environment_service.repository.StationRepository;
import com.example.environment_service.repository.WeatherRepository;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RequiredArgsConstructor
@Service
public class EnvironmentService {

    private final WebClient.Builder webClient;

    private final AirQualityRepository airQualityRepository;
    private final AirQualityMapper airQualityMapper;
    private final NoiseLevelRepository noiseLevelRepository;
    private final NoiseLevelMapper noiseLevelMapper;
    private final WeatherRepository weatherRepository;
    private final StationRepository stationRepository;

    private final String JWT_TOKEN_OPERATOR = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJCM1AxcEZucGF4MjZNNm9YQ2c0eTZ0ckhNRWgwMFlKdG5TN3Qwa0FFSDJFIn0.eyJleHAiOjE3NDIyMTc5MTksImlhdCI6MTc0MjIxNzg1OSwianRpIjoiN2U5NDNkN2YtNTUwMy00YWY4LWFlMzQtNzg1NjM0ODk2YzdlIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MTgxL3JlYWxtcy9tYXN0ZXIiLCJhdWQiOiJhY2NvdW50Iiwic3ViIjoiMDdmNGYwNTItMGFjNS00ZTMwLWJiNjUtNGQzNWQ2NzMyNTk2IiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiYXV0aC1wcm9ibGVtIiwic2lkIjoiNjdjMTViNGQtOGQ5NS00NzlhLTk5OGYtMzA2YTQ3MTU0N2QyIiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyIvKiJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsiZGVmYXVsdC1yb2xlcy1tYXN0ZXIiLCJPUEVSQVRPUiIsIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUiLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwicHJlZmVycmVkX3VzZXJuYW1lIjoiam9obl9kb2UiLCJlbWFpbCI6ImpvaG5AZXhhbXBsZS5jb20ifQ.FOqduT1jPgK4IS3JLJ2gWYkC5DxrD_aKaaUODkq9P88PmDbzp1x3hINWaqXnR2fpTxcDtZ5NxR0qOpokUSrHB2n6hoxncWCSvz-scPD6DOptxPSoe9qA9fX6NTZYwrDai7T_93bCkG5BCSLxg0QggTosu0EIdeUlM0RiE0LXqVlifA7cQ02QfbrL4pioPu341wLKZKPGACXA2gnn47YYDq-bFPSKI51UarymfDzPoS-ZFTjGk88anQHYFVH5-b7rvLzsDzxZWJkxo_DDYCy7oktebYdv5G0XcCmlnewtP58hUSvXjCRpiAu8NdYIsnAxwXtNhNrWehRbUpeUjSbkNw";

    public AirQuality addAirQuality(@Valid AirQualityRequest request) {
        AirQuality airQuality = airQualityMapper.toEntity(request);
        return airQualityRepository.save(airQuality);
    }

    public NoiseLevelResponse addNoiseLevel(@Valid NoiseLevelRequest request) {
        NoiseLevelResponse response = noiseLevelMapper.toResponse(request);

        Station station = stationRepository.findById(request.getStationId()).orElseThrow();

        NoiseLevel noiseLevel = new NoiseLevel();

        noiseLevel.setStation(station);
        noiseLevel.setTimestamp(request.getTimestamp());
        noiseLevel.setDecibelLevel(request.getDecibelLevel());
        noiseLevel.setClassification(request.getClassification());

        noiseLevelRepository.save(noiseLevel);

        Flux<VehicleResponse> vehiclesFlux = webClient
                .baseUrl("http://transport-service")
                .build()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/transport/vehicle/get-all")
                        .queryParamIfPresent("currentLocationId", Optional.ofNullable(request.getLocationId()))
                        .build())
                .headers(headers -> headers.setBearerAuth(JWT_TOKEN_OPERATOR.trim()))
                .retrieve()
                .bodyToFlux(VehicleResponse.class);

        response.setCountOfTransport(Math.toIntExact(vehiclesFlux.count().block()));

        return response;
    }

    public List<AirQuality> getAirQuality(double latitude, double longitude, double radius) {
        return airQualityRepository.findNearestAirQualities(latitude, longitude, radius);
    }

    public List<AirQuality> getAirQualityHistory(UUID stationId, Instant startDate, Instant endDate) {
        return airQualityRepository.findAirQualityHistory(stationId, startDate, endDate);
    }

    public NoiseLevel getNoiseLevels(double latitude, double longitude, double radius) {
        return noiseLevelRepository.findNearestNoiseLevels(latitude, longitude, radius);
    }

    public Weather getWeather(double latitude, double longitude) {
        return weatherRepository.findNearestWeather(latitude, longitude);
    }

    public List<Weather> getWeatherForecast(double latitude, double longitude, Instant days) {
        return weatherRepository.findWeatherForecast(latitude, longitude, days);
    }
}