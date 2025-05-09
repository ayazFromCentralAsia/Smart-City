package com.example.environment_service.mapper;

import com.example.environment_service.dto.Requests.NoiseLevelRequest;
import com.example.environment_service.dto.Responses.NoiseLevelResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-07T17:14:30+0600",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class NoiseLevelMapperImpl implements NoiseLevelMapper {

    @Override
    public NoiseLevelResponse toResponse(NoiseLevelRequest request) {
        if ( request == null ) {
            return null;
        }

        NoiseLevelResponse noiseLevelResponse = new NoiseLevelResponse();

        noiseLevelResponse.setStationId( request.getStationId() );
        noiseLevelResponse.setLocationId( request.getLocationId() );
        noiseLevelResponse.setTimestamp( request.getTimestamp() );
        noiseLevelResponse.setDecibelLevel( request.getDecibelLevel() );
        noiseLevelResponse.setClassification( request.getClassification() );

        return noiseLevelResponse;
    }
}
