package com.example.Transport.Service.mapper;


import com.example.Transport.Service.dto.route.RouteGetResponse;
import com.example.Transport.Service.dto.route.VehiclesByRouteResponse;
import com.example.Transport.Service.model.Route;
import com.example.Transport.Service.model.Vehicle;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RouteMapper {
    RouteGetResponse mapToRouteGetResponse(Route route);
}