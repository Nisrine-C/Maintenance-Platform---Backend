package com.enset.maintenance_backend.Services;

import com.enset.maintenance_backend.DTOs.SensorDataDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface SensorDataService {
    List<SensorDataDTO> getAllSensorData();
    SensorDataDTO getSensorDataById(Long id);

    List<SensorDataDTO> getSensorDataForMachineBetweenDates(Integer machineId, LocalDateTime start, LocalDateTime end);
}
