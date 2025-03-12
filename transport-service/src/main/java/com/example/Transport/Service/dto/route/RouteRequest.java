package com.example.Transport.Service.dto.route;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Request for creating or updating a route record")
public class RouteRequest {

    @NotBlank(message = "Name is required")
    @Schema(description = "Name of the route", example = "Downtown Express")
    private String name;

    @NotNull(message = "Starting point is required")
    @Schema(description = "Starting point of the route", example = "Central Station")
    private String startPoint;

    @NotNull(message = "Ending point is required")
    @Schema(description = "Ending point of the route", example = "North Avenue")
    private String endPoint;

    @NotNull(message = "Distance is required")
    @Schema(description = "Total distance of the route (in kilometers)", example = "12.5")
    private Double distance;

    @NotNull(message = "Average time is required")
    @Schema(description = "Average time to complete the route (in minutes)", example = "30")
    private Integer averageTime;
}
