package com.example.Transport.Service.dto.vehicle;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class VehicleLocationResponse {
    private String type;
    private String registrationNumber;
    private String status;
    private Double latitude;
    private Double longitude;
    private Double direction;
}
