package com.enset.maintenance_backend.services;


import com.enset.maintenance_backend.dtos.SensorDataDTO;
import com.enset.maintenance_backend.entities.SensorData;

public interface SensorDataService extends GenericService<SensorDataDTO, SensorData,Long>{
    void deleteSensorData(Long id);
}
