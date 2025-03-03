package com.example.Transport.Service.controller;


import com.example.Transport.Service.model.Vehicle;
import com.example.Transport.Service.service.TransportService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/transport")
@RequiredArgsConstructor
@RestController
@Tag(name = "Transport", description = "Transport API")
public class TransportController {

//    private final TransportService transportService;


//    @PostMapping("/stops/add")
//    public ResponseEntity<String> addStop(@RequestBody StopRequest stop) {
//        return transportService.addStop(stop);
//    }
//    @PostMapping("/location/add")
//    public ResponseEntity<String> addLocation(@RequestBody LocationRequest location) {
//        return transportService.addLocation(location);
//    }
//
//    @PostMapping("/route/add")
//    public ResponseEntity<String> addRoute(@RequestBody RouteRequest route) {
//        return transportService.addRoute(route);
//    }
//    @PostMapping("/vehicles/add")
//    public ResponseEntity<String> addVehicle(@RequestBody VehicleRequest vehicle) {
//        return transportService.addVehicle(vehicle);
//    }


//    @GetMapping("/vehicles")
//    public List<Vehicle> getAllVehicles(int page, int size, String sort) {
//        return transportService.getAllVehicles(page, size, sort);
//    }

//    @GetMapping("/vehicles/{id}")
//    public Vehicle getVehicleById(int id) {
//        return transportService.getVehicleById(id);
//    }
//
//    @GetMapping("/vehicles/{id}/location")
//    public Location getVehicleLocation(int id) {
//        return transportService.getVehicleLocation(id);
//    }
//
//    @GetMapping("/routes")
//    public List<Route> getAllRoutes(int page, int size, String sort) {
//        return transportService.getAllRoutes(page, size, sort);
//    }
//
//    @GetMapping("/routes/{id}")
//    public Route getRouteById(int id) {
//        return transportService.getRouteById(id);
//    }
//
//    @GetMapping("/routes/{id}/vehicles")
//    public List<Vehicle> getVehiclesByRouteId(int id) {
//        return transportService.getVehiclesByRouteId(id);
//    }
//
//    @GetMapping("/schedules")
//    public List<Schedule> getSchedules(int routeId, LocalDate date) {
//        return transportService.getSchedules(routeId, date);
//    }
//
//    @GetMapping("/predictions")
//    public List<Prediction> getPredictions(int stopId, int routeId) {
//        return transportService.getPredictions(stopId, routeId);
//    }
}

//| Эндпоинт | Метод | Описание | Параметры | Ответ |
//        |----------|-------|----------|-----------|-------|
//        | /vehicles | GET | Получение списка всех транспортных средств | page, size, sort | List<Vehicle> |
//        | /vehicles/{id} | GET | Получение информации о транспортном средстве | id (path) | Vehicle object |
//        | /vehicles/{id}/location | GET | Получение текущей локации | id (path) | Location object |
//        | /routes | GET | Получение списка маршрутов | page, size, sort | List<Route> |
//        | /routes/{id} | GET | Получение информации о маршруте | id (path) | Route object |
//        | /routes/{id}/vehicles | GET | Получение транспорта на маршруте | id (path) | List<Vehicle> |
//        | /schedules | GET | Получение расписания | routeId, date | List<Schedule> |
//        | /predictions | GET | Прогноз прибытия | stopId, routeId | List<Prediction> |