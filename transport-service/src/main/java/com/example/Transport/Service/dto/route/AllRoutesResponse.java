package com.example.Transport.Service.dto.route;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AllRoutesResponse {
    private String name;
    private String startPoint;
    private String endPoint;
    private Double distance;
    private Integer averageTime;
}
