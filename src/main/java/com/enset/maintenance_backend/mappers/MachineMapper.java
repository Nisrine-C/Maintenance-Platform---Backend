package com.enset.maintenance_backend.mappers;

import com.enset.maintenance_backend.dtos.MachineDTO;
import com.enset.maintenance_backend.entities.Machine;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MachineMapper extends BaseMapper<Machine, MachineDTO>{
    @Override
    public MachineDTO fromEntity(Machine entity) {
        MachineDTO machineDTO = new MachineDTO();
        BeanUtils.copyProperties(entity, machineDTO);
        return machineDTO;
    }

    @Override
    public Machine fromDTO(MachineDTO dto) {
        Machine machine = new Machine();
        BeanUtils.copyProperties(dto,machine);
        return machine;
    }

}
