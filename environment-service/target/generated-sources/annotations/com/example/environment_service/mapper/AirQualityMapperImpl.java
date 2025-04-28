package com.example.environment_service.mapper;

import com.example.environment_service.dto.Requests.AirQualityRequest;
import com.example.environment_service.entity.AirQuality;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-28T21:01:28+0600",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class AirQualityMapperImpl implements AirQualityMapper {

    @Override
    public AirQuality toEntity(AirQualityRequest request) {
        if ( request == null ) {
            return null;
        }

        AirQuality airQuality = new AirQuality();

        airQuality.setTimestamp( request.getTimestamp() );
        airQuality.setPm25( request.getPm25() );
        airQuality.setPm10( request.getPm10() );
        airQuality.setNo2( request.getNo2() );
        airQuality.setSo2( request.getSo2() );
        airQuality.setO3( request.getO3() );
        airQuality.setCo( request.getCo() );
        airQuality.setAqi( request.getAqi() );
        airQuality.setQualityIndex( request.getQualityIndex() );

        return airQuality;
    }
}
