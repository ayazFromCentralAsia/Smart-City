package com.example.security_service.service.impl;

import com.example.security_service.dto.incidents.IncidentByFilterResponse;
import com.example.security_service.dto.incidents.IncidentRequest;
import com.example.security_service.entity.Incident;
import com.example.security_service.repository.IncidentRepository;
import com.example.security_service.repository.PerimeterRepository;
import com.example.security_service.service.IncidentsServiceInterface;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IncidentsService implements IncidentsServiceInterface {

    private final IncidentRepository incidentRepository;
    private final PerimeterRepository perimeterRepository;

    @Override
    public List<IncidentByFilterResponse> getIncidentsByFilter(Incident.Status status, String type) {
        List<Incident> list = incidentRepository.findByStatusAndType(status, type);
        List<IncidentByFilterResponse> responseList = new ArrayList<>();

        for (Incident incident : list) {
            IncidentByFilterResponse response = new IncidentByFilterResponse();
            response.setStatus(incident.getStatus());
            response.setType(incident.getType());
            response.setCreatedAt(incident.getCreatedAt());
            response.setDescription(incident.getDescription());
            response.setPerimeterId(incident.getPerimeter().getId());
            responseList.add(response);
        }

        return responseList;
    }

    @Override
    public String getIncidentById(Integer id) {
        Incident incident = incidentRepository.findById(id).orElse(null);
        return incident.getDescription();
    }

    @Override
    public String createIncident(IncidentRequest incident) {
        Incident newIncident = new Incident();
        newIncident.setStatus(Incident.Status.valueOf(incident.getStatus()));
        newIncident.setType(incident.getType());
        newIncident.setDescription(incident.getDescription());
        newIncident.setPerimeter(perimeterRepository.findById(incident.getPerimeterId()).orElse(null));
        return incidentRepository.save(newIncident).getId().toString();
    }
}