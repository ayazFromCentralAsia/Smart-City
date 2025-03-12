package com.example.Transport.Service.dto.vehicle;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Request object for creating a new vehicle")
public class VehicleRequest {

    @NotBlank(message = "Type cannot be empty")
    @Schema(description = "Type of transport vehicle", example = "BUS")
    private String type;

    @Size(min = 2, max = 255)
    @Schema(description = "Registration number of the transport vehicle", example = "AB123CD")
    private String registrationNumber;

    @NotNull(message = "Capacity cannot be null")
    @Schema(description = "Capacity of the transport vehicle", example = "20")
    private int capacity;

    @NotBlank(message = "Status cannot be empty")
    @Schema(description = "Status of the transport vehicle", example = "ACTIVE")
    private String status;

    @NotNull(message = "Current location ID cannot be null")
    @Schema(description = "ID current location of the transport vehicle", example = "1")
    private Long currentLocationId;

    @NotBlank(message = "Current route ID cannot be empty")
    @Schema(description = "ID of the route the transport vehicle is currently on", example = "5")
    private Long currentRouteId;
}
