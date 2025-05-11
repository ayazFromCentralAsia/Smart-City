package com.example.Transport.Service.mapper;

import com.example.Transport.Service.dto.route.RouteGetResponse;
import com.example.Transport.Service.model.Route;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-10T10:58:43+0600",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class RouteMapperImpl implements RouteMapper {

    @Override
    public RouteGetResponse mapToRouteGetResponse(Route route) {
        if ( route == null ) {
            return null;
        }

        RouteGetResponse routeGetResponse = new RouteGetResponse();

        routeGetResponse.setName( route.getName() );
        routeGetResponse.setStartPoint( route.getStartPoint() );
        routeGetResponse.setEndPoint( route.getEndPoint() );
        routeGetResponse.setDistance( route.getDistance() );
        routeGetResponse.setAverageTime( route.getAverageTime() );

        return routeGetResponse;
    }
}
