package com.example.security_service.controller;

import com.example.security_service.dto.hotspots.HotspotResponse;
import com.example.security_service.service.HotspotsServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@Tag(name = "Hotspots", description = "Контроллер для работы с горячими точками в городе")
public class HotspotsController {

    private final HotspotsServiceInterface hotspotsServiceInterface;

    @GetMapping("/analytics/hotspots")
    @Operation(tags = "Hotspots", summary = "Метод для получения списко горячих точек. ",
            description = "Метод для получения списко горячих точек. " +
                    "За какое то время. Требывания нужно указать число в таком виде 2022-01-01T12:00:00Z")
    public List<HotspotResponse> getAllHotspots(
            @RequestParam(name = "from", required = false, defaultValue = "2022-01-01T12:00:00Z") ZonedDateTime from,
            @RequestParam(name = "to", required = false, defaultValue = "2022-01-01T12:00:00Z") ZonedDateTime to) {
        return hotspotsServiceInterface.getHotspotsByTime(from, to);
    }

}