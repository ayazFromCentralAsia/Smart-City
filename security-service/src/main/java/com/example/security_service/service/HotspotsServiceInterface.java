package com.example.security_service.service;

import com.example.security_service.dto.hotspots.HotspotResponse;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.List;

public interface HotspotsServiceInterface {
    List<HotspotResponse> getHotspotsByTime(ZonedDateTime from, ZonedDateTime to);
}
