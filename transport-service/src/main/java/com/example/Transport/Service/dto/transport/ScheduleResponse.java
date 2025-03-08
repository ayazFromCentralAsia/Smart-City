package com.example.Transport.Service.dto.transport;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class ScheduleResponse {
    @Schema(description = "Name of the route", example = "Downtown Express")
    @NotBlank(message = "Name is required")
    private String routeName;
    @Schema(description = "Starting point of the route", example = "Central Station")
    @NotBlank(message = "Starting point is required")
    private List<Long> vehicles;
    @Schema(description = "Stops of the route", example = "Central Station, North Avenue")
    @NotNull(message = "Stops are required")
    private List<Long> stops;
    @Schema(description = "Date of the schedule", example = "2022-05-01")
    @NotNull(message = "Date is required")
    private LocalDate date;
}