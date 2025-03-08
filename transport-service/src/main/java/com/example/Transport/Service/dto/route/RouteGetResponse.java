package com.example.Transport.Service.dto.route;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteGetResponse {
    private String name;
    private String startPoint;
    private String endPoint;
    private Double distance;
    private Integer averageTime;
}