package com.enset.maintenance_backend.services;

import com.enset.maintenance_backend.dtos.MachineDTO;
import com.enset.maintenance_backend.entities.Machine;

import java.util.List;

public interface MachineService extends GenericService<MachineDTO,Machine,Long>{
    void deleteMachine(Long id);
}
