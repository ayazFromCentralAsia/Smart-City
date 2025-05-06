package com.example.security_service.controller;

import com.example.security_service.dto.perimeter.PerimeterRequest;
import com.example.security_service.service.PerimeterServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Tag( name= "Perimeter", description = "Контроллеры для управления пермиметрами" )
public class PerimeterController {

    private final PerimeterServiceInterface perimeterService;

    @PostMapping("/perimeters")
    @Operation(summary = "Метод для создания нового периметрам")
    public ResponseEntity<?> createPerimeter(PerimeterRequest perimeterRequest) {
        return ResponseEntity.ok(perimeterService.createPerimeter(perimeterRequest));
    }
}