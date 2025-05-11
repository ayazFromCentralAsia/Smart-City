package com.example.Transport.Service.mapper;

import com.example.Transport.Service.dto.vehicle.VehicleGetResponse;
import com.example.Transport.Service.dto.vehicle.VehicleLocationResponse;
import com.example.Transport.Service.dto.vehicle.VehicleResponse;
import com.example.Transport.Service.model.Vehicle;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-10T10:58:42+0600",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class VehicleMapperImpl implements VehicleMapper {

    @Override
    public VehicleResponse vehicleToVehicleResponse(Vehicle vehicle) {
        if ( vehicle == null ) {
            return null;
        }

        VehicleResponse.VehicleResponseBuilder vehicleResponse = VehicleResponse.builder();

        if ( vehicle.getType() != null ) {
            vehicleResponse.type( vehicle.getType().name() );
        }
        vehicleResponse.registrationNumber( vehicle.getRegistrationNumber() );
        if ( vehicle.getCapacity() != null ) {
            vehicleResponse.capacity( vehicle.getCapacity() );
        }
        if ( vehicle.getStatus() != null ) {
            vehicleResponse.status( vehicle.getStatus().name() );
        }

        return vehicleResponse.build();
    }

    @Override
    public VehicleGetResponse vehicleToVehicleGetResponse(Vehicle vehicle) {
        if ( vehicle == null ) {
            return null;
        }

        VehicleGetResponse vehicleGetResponse = new VehicleGetResponse();

        if ( vehicle.getType() != null ) {
            vehicleGetResponse.setType( vehicle.getType().name() );
        }
        vehicleGetResponse.setRegistrationNumber( vehicle.getRegistrationNumber() );
        if ( vehicle.getCapacity() != null ) {
            vehicleGetResponse.setCapacity( vehicle.getCapacity() );
        }
        if ( vehicle.getStatus() != null ) {
            vehicleGetResponse.setStatus( vehicle.getStatus().name() );
        }

        return vehicleGetResponse;
    }

    @Override
    public List<VehicleResponse> vehiclesToVehicleResponses(List<Vehicle> vehicles) {
        if ( vehicles == null ) {
            return null;
        }

        List<VehicleResponse> list = new ArrayList<VehicleResponse>( vehicles.size() );
        for ( Vehicle vehicle : vehicles ) {
            list.add( vehicleToVehicleResponse( vehicle ) );
        }

        return list;
    }

    @Override
    public VehicleLocationResponse vehicleToVehicleLocationResponse(Vehicle vehicle) {
        if ( vehicle == null ) {
            return null;
        }

        VehicleLocationResponse.VehicleLocationResponseBuilder vehicleLocationResponse = VehicleLocationResponse.builder();

        if ( vehicle.getType() != null ) {
            vehicleLocationResponse.type( vehicle.getType().name() );
        }
        vehicleLocationResponse.registrationNumber( vehicle.getRegistrationNumber() );
        if ( vehicle.getStatus() != null ) {
            vehicleLocationResponse.status( vehicle.getStatus().name() );
        }

        return vehicleLocationResponse.build();
    }
}
