package com.example.environment_service.dto.Responses;

import com.example.environment_service.entity.Station;

import java.time.LocalDateTime;

public class WeatherForecast {
    private Long id;

    private Station station;
    private LocalDateTime timestamp;
    private double temperature;
    private double humidity;
    private double windSpeed;
    private double windDirection;
    private double precipitation;
    private String condition;
}
