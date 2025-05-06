package com.example.security_service.service;

import com.example.security_service.dto.cameras.CameraRequest;
import com.example.security_service.dto.cameras.CameraResponse;
import com.example.security_service.entity.Camera;
import com.example.security_service.enums.CamerasStatus;

import java.util.List;

public interface CamerasServiceInterface {
    List<CameraResponse> getCameras(String zone, Camera.Status status, Integer perimeterId);

    String getCameraStream(Integer id);

    String createCamera(CameraRequest cameraRequest);

    String updateCameraStatus(Integer id, Camera.Status status);

    String deleteCamera(Integer id);
}
