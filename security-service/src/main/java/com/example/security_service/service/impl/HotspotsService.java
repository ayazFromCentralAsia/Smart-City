package com.example.security_service.service.impl;

import com.example.security_service.dto.hotspots.HotspotResponse;
import com.example.security_service.service.HotspotsServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotspotsService implements HotspotsServiceInterface {
    @Override
    public List<HotspotResponse> getHotspotsByTime(String from, String to) {
        return List.of();
    }
}
