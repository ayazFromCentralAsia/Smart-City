package com.example.security_service.service;

import com.example.security_service.dto.perimeter.PerimeterRequest;

public interface PerimeterServiceInterface {
    Object createPerimeter(PerimeterRequest perimeterRequest);
}
