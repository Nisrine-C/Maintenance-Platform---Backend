package com.enset.maintenance_backend.mappers;

import com.enset.maintenance_backend.dtos.SensorDataDTO;
import com.enset.maintenance_backend.entities.SensorData;
import org.springframework.beans.BeanUtils;

public class SensorDataMapper extends BaseMapper<SensorData, SensorDataDTO> {
    @Override
    public SensorDataDTO fromEntity(SensorData entity) {
        SensorDataDTO sensorDataDTO = new SensorDataDTO();
        BeanUtils.copyProperties(entity, sensorDataDTO);
        return sensorDataDTO;
    }

    @Override
    public SensorData fromDTO(SensorDataDTO dto) {
        SensorData sensorData = new SensorData();
        BeanUtils.copyProperties(dto, sensorData);
        return sensorData;
    }
}
