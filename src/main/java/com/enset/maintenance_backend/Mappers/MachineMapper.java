package com.enset.maintenance_backend.Mappers;

import com.enset.maintenance_backend.DTOs.MachineDTO;
import com.enset.maintenance_backend.Entities.Machine;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MachineMapper {
    public MachineDTO fromMachine(Machine machine) {
        MachineDTO machineDTO = new MachineDTO();
        BeanUtils.copyProperties(machine, machineDTO);
        return machineDTO;
    }
    public Machine fromMachineDTO(MachineDTO machineDTO) {
        Machine machine = new Machine();
        BeanUtils.copyProperties(machineDTO, machine);
        return machine;
    }
    public void updateMachineFromDTO(MachineDTO dto, Machine entity){
        if (dto.getName() != null) {
            entity.setName(dto.getName());
        }
        if (dto.getSerialNumber() != null) {
            entity.setSerialNumber(dto.getSerialNumber());
        }
    }

}

