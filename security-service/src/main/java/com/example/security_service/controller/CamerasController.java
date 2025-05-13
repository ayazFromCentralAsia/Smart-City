package com.example.security_service.controller;


import com.example.security_service.dto.cameras.CameraRequest;
import com.example.security_service.dto.cameras.CameraResponse;
import com.example.security_service.entity.Camera;
import com.example.security_service.enums.CamerasStatus;
import com.example.security_service.service.CamerasServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/security")
@Tag(name = "Cameras", description = "Контроллер для работы с камерами")
public class CamerasController {
    private final CamerasServiceInterface camerasServiceInterface;

    @GetMapping("/cameras")
    @Operation(summary = "Список камер по фильтру",
        description = "Тут можно брать камеры по фильтру: по зоне, статусу, и по периметру." +
                "Требывания такие, Статус может быть ONLINE, OFFLINE, MAINTENANCE. Периметр - это id периметра в таблице perimeter.",
        tags = {"Cameras"})
    public List<CameraResponse> getCameras(
            @RequestParam(required = false) String zone,
            @RequestParam(required = false) Camera.Status status,
            @RequestParam(required = false) Integer perimeterId) {
        return camerasServiceInterface.getCameras(zone, status, perimeterId);
    }

    @GetMapping("/cameras/stream")
    @Operation(summary = "Получение потока с камеры",
        description = "Получение потока с камеры по его id",
        tags = {"Cameras"})
    public String getCameraStream(@RequestParam Integer id) {
        return camerasServiceInterface.getCameraStream(id);
    }

    @PostMapping("/cameras")
    @Operation(summary = "Создание камеры",
        description = "Создание камеры с указанием имени, зоны, статуса, потока, и периметра",
        tags = {"Cameras"})
    public ResponseEntity<?> createCamera(@RequestBody CameraRequest cameraRequest) {
        return ResponseEntity.ok(camerasServiceInterface.createCamera(cameraRequest));
    }

    @PutMapping("/cameras/{id}/status")
    @Operation(summary = "Обновление статуса камеры",
        description = "Обновление статуса камеры по его id",
        tags = {"Cameras"})
    public ResponseEntity<?> updateCameraStatus(@PathVariable Integer id, @RequestParam Camera.Status status) {
        return ResponseEntity.ok(camerasServiceInterface.updateCameraStatus(id, status));
    }

    @DeleteMapping("/cameras/{id}")
    @Operation(summary = "Удаление камеры",
        description = "Удаление камеры по его id",
        tags = {"Cameras"})
    public ResponseEntity<?> deleteCamera(@PathVariable Integer id) {
        return ResponseEntity.ok(camerasServiceInterface.deleteCamera(id));
    }
}
