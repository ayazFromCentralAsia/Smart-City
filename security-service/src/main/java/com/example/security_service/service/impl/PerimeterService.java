package com.example.security_service.service.impl;

import com.example.security_service.dto.perimeter.PerimeterRequest;
import com.example.security_service.service.PerimeterServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PerimeterService implements PerimeterServiceInterface {
    @Override
    public Object createPerimeter(PerimeterRequest perimeterRequest) {
        return null;
    }
}
