package com.enset.maintenance_backend.Services;

import com.enset.maintenance_backend.DTOs.MachineDTO;
import com.enset.maintenance_backend.DTOs.MaintenanceActionDTO;
import com.enset.maintenance_backend.DTOs.SensorDataDTO;
import com.enset.maintenance_backend.Entities.Machine;
import com.enset.maintenance_backend.Entities.MaintenanceAction;
import com.enset.maintenance_backend.Entities.SensorData;

import java.util.List;

public interface MachineService {
    List<MachineDTO> getAllMachines();
    MachineDTO getMachineById(Long id);
    MachineDTO createMachine(MachineDTO machine);
    MachineDTO updateMachine(Long id, MachineDTO machineDTO);
    void deleteMachine(Long id);


}
