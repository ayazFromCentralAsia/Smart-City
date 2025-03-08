package com.example.Transport.Service.dto.vehicle;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehicleResponse {
    private String type;
    private String registrationNumber;
    private int capacity;
    private String status;
}
