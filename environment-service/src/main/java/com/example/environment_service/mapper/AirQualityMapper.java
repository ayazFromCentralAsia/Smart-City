package com.example.environment_service.mapper;

import com.example.environment_service.dto.Requests.AirQualityRequest;
import com.example.environment_service.entity.AirQuality;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AirQualityMapper {
    AirQuality toEntity(AirQualityRequest request);
}
