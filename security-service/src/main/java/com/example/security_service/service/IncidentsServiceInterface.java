package com.example.security_service.service;

import com.example.security_service.dto.incidents.IncidentByFilterResponse;
import com.example.security_service.dto.incidents.IncidentRequest;
import com.example.security_service.entity.Incident;

import java.util.List;

public interface IncidentsServiceInterface {
    List<IncidentByFilterResponse> getIncidentsByFilter(String status, String type);

    Incident getIncidentById(Integer id);

    Incident createIncident(IncidentRequest incident);
}
