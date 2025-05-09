package com.example.security_service.service;

import com.example.security_service.dto.incidents.IncidentByFilterResponse;
import com.example.security_service.dto.incidents.IncidentRequest;
import com.example.security_service.entity.Incident;

import java.util.List;

public interface IncidentsServiceInterface {
    List<IncidentByFilterResponse> getIncidentsByFilter(Incident.Status status, String type);

    String getIncidentById(Integer id);

    String createIncident(IncidentRequest incident);
}
