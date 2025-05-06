package com.example.security_service.service.impl;

import com.example.security_service.dto.incidents.IncidentByFilterResponse;
import com.example.security_service.dto.incidents.IncidentRequest;
import com.example.security_service.entity.Incident;
import com.example.security_service.service.IncidentsServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IncidentsService implements IncidentsServiceInterface {
    @Override
    public List<IncidentByFilterResponse> getIncidentsByFilter(String status, String type) {
        return List.of();
    }

    @Override
    public Incident getIncidentById(Integer id) {
        return null;
    }

    @Override
    public Incident createIncident(IncidentRequest incident) {
        return null;
    }
}
