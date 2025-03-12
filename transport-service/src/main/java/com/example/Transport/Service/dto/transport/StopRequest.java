package com.example.Transport.Service.dto.transport;

import lombok.Data;

import java.util.List;

@Data
public class StopRequest {
    private String name;
    private Long locationId;
    private List<String> facilities;
}
