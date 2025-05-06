package com.example.security_service.controller;

import com.example.security_service.dto.incidents.IncidentRequest;
import com.example.security_service.dto.incidents.IncidentByFilterResponse;
import com.example.security_service.entity.Incident;
import com.example.security_service.service.IncidentsServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@Tag(name = "Incidents", description = "Контроллер для управления инцидентами в городе.")
public class IncidentsController {
    private final IncidentsServiceInterface incidentsService;

    @GetMapping("/incidents")
    @Operation( summary = "Список инцидентов",
            description = "Возвращает список инцидентов в городе, которые соответствуют указанным параметрам." )
    public List<IncidentByFilterResponse> getIncidentsByFilter(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String type) {
        return incidentsService.getIncidentsByFilter(status, type);
    }

    @GetMapping("/incidents/{id}")
    @Operation( summary = "Детали инцидента",
            description = "Возвращает детали инцидента по его идентификатору." )
    public Incident getIncidentById(@PathVariable("id") Integer id) {
        return incidentsService.getIncidentById(id);
    }

    @PostMapping("/incidents")
    @Operation( summary = "Создание инцидента",
            description = "Создает новый инцидент в городе." )
    public Incident createIncident(@RequestBody IncidentRequest incident) {
        return incidentsService.createIncident(incident);
    }

}