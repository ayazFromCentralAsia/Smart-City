package com.example.security_service.dto.cameras;

import com.example.security_service.entity.Camera;
import com.example.security_service.enums.CamerasStatus;
import lombok.Data;

@Data
public class CameraResponse {
    private int id;
    private String name;
    private String zone;
    private Camera.Status status;
    private String streamUrl;
    private int perimeterId;
}

