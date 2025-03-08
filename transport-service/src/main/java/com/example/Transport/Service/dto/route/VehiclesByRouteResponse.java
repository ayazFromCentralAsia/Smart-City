package com.example.Transport.Service.dto.route;

import com.example.Transport.Service.dto.vehicle.VehicleResponse;
import lombok.*;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehiclesByRouteResponse {

    private String name;
    private String startPoint;
    private String endPoint;
    private Double distance;
    private Integer averageTime;
    private List<VehicleResponse> vehicles;
}
