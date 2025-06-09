package com.enset.maintenance_backend.services;


import com.enset.maintenance_backend.dtos.HistogramBinDto;
import com.enset.maintenance_backend.dtos.SensorDataDTO;
import com.enset.maintenance_backend.dtos.VibrationTrendDto;
import com.enset.maintenance_backend.entities.SensorData;

import java.util.List;

public interface SensorDataService extends GenericService<SensorDataDTO, SensorData,Long>{
    void deleteSensorData(Long id);
    List<VibrationTrendDto> getVibrationTrends(Long machineId);
    List<HistogramBinDto> getVibrationHistogram(Long machineId, double binSize);
}
