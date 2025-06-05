package com.enset.maintenance_backend.web;

import com.enset.maintenance_backend.dtos.SensorDataDTO;
import com.enset.maintenance_backend.services.SensorDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensor-data")
@RequiredArgsConstructor
public class SensorDataController {

    private final SensorDataService sensorDataService;

    @GetMapping
    public List<SensorDataDTO> getAllSensorData() {
        return sensorDataService.findAll();
    }

    @GetMapping("/sensor-data/{id}")
    public SensorDataDTO getSensorDataById(@PathVariable Long id) {
        return sensorDataService.getEntityById(id);
    }

    @PostMapping
    public SensorDataDTO createSensorData(@RequestBody SensorDataDTO dto) {
        return sensorDataService.create(dto);
    }

    @PutMapping("/sensor-data/{id}")
    public SensorDataDTO updateSensorData(@PathVariable Long id, @RequestBody SensorDataDTO dto) {
        return sensorDataService.update(id, dto);
    }

    @DeleteMapping("/sensor-data/{id}")
    public void deleteSensorData(@PathVariable Long id) {
        sensorDataService.deleteSensorData(id);
    }

    @PatchMapping("/sensor-data/{id}/soft-delete")
    public void softDeleteSensorData(@PathVariable Long id) {
        sensorDataService.softDelete(id);
    }
}
