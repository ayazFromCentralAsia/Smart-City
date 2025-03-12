package com.example.Transport.Service.mapper;

import com.example.Transport.Service.dto.vehicle.VehicleGetResponse;
import com.example.Transport.Service.dto.vehicle.VehicleLocationResponse;
import com.example.Transport.Service.dto.vehicle.VehicleResponse;
import com.example.Transport.Service.model.Vehicle;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    VehicleResponse vehicleToVehicleResponse(Vehicle vehicle);

    VehicleGetResponse vehicleToVehicleGetResponse(Vehicle vehicle);

    List<VehicleResponse> vehiclesToVehicleResponses(List<Vehicle> vehicles);

    VehicleLocationResponse vehicleToVehicleLocationResponse(Vehicle vehicle);
}