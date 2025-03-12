package com.example.Transport.Service.dto.vehicle;

import com.example.Transport.Service.model.Location;
import com.example.Transport.Service.model.Route;
import com.example.Transport.Service.model.Vehicle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleGetResponse {
    private String type;
    private String registrationNumber;
    private int capacity;
    private String status;
}