package com.example.Transport.Service.dto.location;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.OffsetDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Request for creating or updating a location record")
public class LocationRequest {

    @Schema(description = "Latitude of the location", example = "37.7749")
    @NotNull(message = "Latitude cannot be null")
    private Double latitude;

    @Schema(description = "Longitude of the location", example = "-122.4194")
    @NotNull(message = "Longitude cannot be null")
    private Double longitude;

    @Schema(description = "Timestamp of the recorded location", example = "2024-03-04T12:30:45Z")
    @NotNull(message = "Timestamp cannot be null")
    private OffsetDateTime timestamp;

    @Schema(description = "Speed at the given location (in km/h)", example = "60.5")
    @NotNull(message = "Speed cannot be null")
    private Double speed;

    @Schema(description = "Direction of movement (in degrees)", example = "180.0")
    @NotNull(message = "Direction cannot be null")
    private Double direction;
}
