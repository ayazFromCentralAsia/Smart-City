package com.example.security_service.service.impl;

import com.example.security_service.dto.hotspots.HotspotResponse;
import com.example.security_service.entity.Hotspot;
import com.example.security_service.repository.HotspotRepository;
import com.example.security_service.service.HotspotsServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HotspotsService implements HotspotsServiceInterface {

    private final HotspotRepository hotspotRepository;

    @Override
    public List<HotspotResponse> getHotspotsByTime(ZonedDateTime from, ZonedDateTime to) {
        List<Hotspot> list = hotspotRepository.findByTime(from, to);
        List<HotspotResponse> hotspotResponseList = new ArrayList<>();
        for(Hotspot hotspot : list){
            HotspotResponse hotspotResponse = new HotspotResponse();

            hotspotResponse.setType(hotspot.getType());
            hotspotResponse.setIntensity(hotspot.getIntensity());
            hotspotResponse.setLatitude(hotspot.getLatitude());
            hotspotResponse.setLongitude(hotspot.getLongitude());

            hotspotResponseList.add(hotspotResponse);
        }

        return hotspotResponseList;
    }
}
