package com.enset.maintenance_backend.mappers;

import com.enset.maintenance_backend.dtos.FailureDTO;
import com.enset.maintenance_backend.entities.Failure;
import com.enset.maintenance_backend.entities.Machine;
import com.enset.maintenance_backend.repositories.MachineRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FailureMapper extends BaseMapper<Failure, FailureDTO> {
    @Autowired
    private MachineRepository machineRepository;
    @Override
    public FailureDTO fromEntity(Failure entity) {
       FailureDTO failureDTO = new FailureDTO();
        BeanUtils.copyProperties(entity, failureDTO);
       // failureDTO.setMachineId((entity.getMachine().getId()));
        return failureDTO;

    }

    @Override
    public Failure fromDTO(FailureDTO dto) {
        Failure failure = new Failure();
        BeanUtils.copyProperties(dto, failure);
//        Machine machine = machineRepository.findById((dto.getMachineId()))
//                .orElseThrow(() -> new RuntimeException("Machine not found with id " + dto.getMachineId()));
//        failure.setMachine(machine);
        return failure;
    }
}
