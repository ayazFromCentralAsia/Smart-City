package com.example.environment_service.mapper;


import com.example.environment_service.dto.Requests.NoiseLevelRequest;
import com.example.environment_service.dto.Responses.NoiseLevelResponse;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoiseLevelMapper {
    NoiseLevelResponse toResponse(@Valid NoiseLevelRequest request);
}
