package com.example.security_service.service.impl;

import com.example.security_service.dto.perimeter.PerimeterRequest;
import com.example.security_service.entity.Camera;
import com.example.security_service.entity.Perimeter;
import com.example.security_service.repository.CameraRepository;
import com.example.security_service.repository.PerimeterRepository;
import com.example.security_service.service.PerimeterServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PerimeterService implements PerimeterServiceInterface {

    private final PerimeterRepository perimeterRepository;
    private final CameraRepository cameraRepository;

    @Override
    public String createPerimeter(PerimeterRequest perimeterRequest) {
        Perimeter perimeter = new Perimeter();

        perimeter.setLongitude(perimeterRequest.getLongitude());
        perimeter.setLatitude(perimeterRequest.getLatitude());
        perimeter.setRadius(perimeterRequest.getRadius());

        List<Camera> list = new ArrayList<>();
        for (Integer cameraId: perimeterRequest.getListOfCamera()){
            Camera camera = cameraRepository.findById(cameraId).orElse(null);

            if (camera == null){
                throw new IllegalArgumentException("Camera is not exist by this ID");
            }
            list.add(camera);
        }
        perimeter.setCameras(list);
        return perimeterRepository.save(perimeter).getId().toString();
    }
}
