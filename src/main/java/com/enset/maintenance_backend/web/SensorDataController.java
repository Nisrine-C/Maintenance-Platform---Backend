package com.enset.maintenance_backend.web;

import com.enset.maintenance_backend.dtos.HistogramBinDto;
import com.enset.maintenance_backend.dtos.SensorDataDTO;
import com.enset.maintenance_backend.dtos.VibrationTrendDto;
import com.enset.maintenance_backend.services.SensorDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class SensorDataController {

    private final SensorDataService sensorDataService;

    @GetMapping("/sensor-data")
    public List<SensorDataDTO> getAllSensorData() {
        return sensorDataService.findAll();
    }

    @GetMapping("/sensor-data/{id}")
    public SensorDataDTO getSensorDataById(@PathVariable Long id) {
        return sensorDataService.getEntityById(id);
    }

    @PostMapping("/sensor-data")
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

    @GetMapping("/trends")
    public List<VibrationTrendDto> getTrends(@RequestParam Long machineId) {
        return sensorDataService.getVibrationTrends(machineId);
    }

    @GetMapping("/histogram")
    public List<HistogramBinDto> getHistogram(@RequestParam Long machineId,
                                              @RequestParam(defaultValue = "0.2") double binSize) {
        return sensorDataService.getVibrationHistogram(machineId, binSize);
    }
}
