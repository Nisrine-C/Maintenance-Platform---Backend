package com.enset.maintenance_backend.mappers;

import com.enset.maintenance_backend.dtos.SensorDataDTO;
import com.enset.maintenance_backend.entities.Machine;
import com.enset.maintenance_backend.entities.SensorData;
import com.enset.maintenance_backend.repositories.MachineRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorDataMapper extends BaseMapper<SensorData, SensorDataDTO> {
    @Autowired
    private MachineRepository machineRepository;
    @Override
    public SensorDataDTO fromEntity(SensorData entity) {
        SensorDataDTO sensorDataDTO = new SensorDataDTO();
        BeanUtils.copyProperties(entity, sensorDataDTO);
        sensorDataDTO.setMachineId((entity.getMachine().getId()));
        return sensorDataDTO;
    }

    @Override
    public SensorData fromDTO(SensorDataDTO dto) {
        SensorData sensorData = new SensorData();
        BeanUtils.copyProperties(dto, sensorData);
        Machine machine = machineRepository.findById((dto.getMachineId()))
                .orElseThrow(() -> new RuntimeException("Machine not found with id " + dto.getMachineId()));
        sensorData.setMachine(machine);
        return sensorData;
    }
}
