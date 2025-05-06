package com.example.security_service.service;

import com.example.security_service.dto.hotspots.HotspotResponse;

import java.util.List;

public interface HotspotsServiceInterface {
    List<HotspotResponse> getHotspotsByTime(String from, String to);
}
