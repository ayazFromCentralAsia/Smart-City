package com.example.security_service.service.impl;

import com.example.security_service.dto.cameras.CameraRequest;
import com.example.security_service.dto.cameras.CameraResponse;
import com.example.security_service.entity.Camera;
import com.example.security_service.enums.CamerasStatus;
import com.example.security_service.repository.CameraRepository;
import com.example.security_service.repository.PerimeterRepository;
import com.example.security_service.service.CamerasServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CamerasService implements CamerasServiceInterface {
    private final CameraRepository cameraRepository;
    private final PerimeterRepository perimeterRepository;

    @Override
    public List<CameraResponse> getCameras(String zone, Camera.Status status, Integer perimeterId) {
        List<Camera> cameraList = cameraRepository.findByFilter(zone, status, perimeterId);
        List<CameraResponse> cameraResponseList = new ArrayList<>();
        for (Camera camera : cameraList) {
            CameraResponse cameraResponse = new CameraResponse();
            cameraResponse.setId(camera.getId());
            cameraResponse.setName(camera.getName());
            cameraResponse.setZone(camera.getZone());
            cameraResponse.setStatus(camera.getStatus());
            cameraResponse.setStreamUrl(camera.getStreamUrl());
            cameraResponse.setPerimeterId(camera.getPerimeter().getId());
            cameraResponseList.add(cameraResponse);
        }
        return cameraResponseList;
    }
    @Override
    public String getCameraStream(Integer id) {
        Camera camera = cameraRepository.findById(id).orElse(null);
        if (camera == null) {
            throw new IllegalArgumentException("Camera not found");
        }
        return camera.getStreamUrl();
    }

    @Override
    public String createCamera(CameraRequest cameraRequest) {
        try {
            Camera camera = new Camera();

            camera.setName(cameraRequest.getName());
            camera.setZone(cameraRequest.getZone());
            camera.setStatus(Camera.Status.valueOf(cameraRequest.getStatus()));
            camera.setStreamUrl(cameraRequest.getStreamUrl());
            camera.setPerimeter(perimeterRepository.findById(cameraRequest.getPerimeterId()).orElse(null));
            cameraRepository.save(camera);

            return "Camera created successfully";
        } catch (Exception e) {
            throw new IllegalArgumentException("Error creating camera");
        }
    }

    @Override
    public String updateCameraStatus(Integer id, Camera.Status status) {
        try {
            Camera camera = cameraRepository.findById(id).orElse(null);
            if (camera == null) {
                throw new IllegalArgumentException("Camera not found");
            }
            camera.setStatus(status);
            cameraRepository.save(camera);

            return "Camera status updated successfully";
        }catch (Exception e){
            throw new IllegalArgumentException("Error updating camera status");
        }
    }

    @Override
    public String deleteCamera(Integer id) {
        try {
            cameraRepository.deleteById(id);

            return "Camera deleted successfully";
        }catch (Exception e){
            throw new IllegalArgumentException("Error deleting camera");
        }
    }
}
