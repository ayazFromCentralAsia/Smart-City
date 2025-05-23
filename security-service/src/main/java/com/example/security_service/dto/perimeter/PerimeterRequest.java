package com.example.security_service.dto.perimeter;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "ДТО для создания периметра")
@Data
public class PerimeterRequest {
    @Schema(description = "Широта", example = "55.555555")
    private Double latitude;
    @Schema(description = "Долгота", example = "37.333333")
    private Double longitude;
    @Schema(description = "Радиус", example = "100")
    private Integer radius;
    @Schema(description = "Ид камер в периметре", example = "1")
    private List<Integer> listOfCamera;
}