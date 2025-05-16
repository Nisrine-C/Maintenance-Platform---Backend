package com.enset.maintenance_backend.mappers;


import com.enset.maintenance_backend.dtos.MaintenanceActionDTO;
import com.enset.maintenance_backend.entities.Machine;
import com.enset.maintenance_backend.entities.MaintenanceAction;
import com.enset.maintenance_backend.repositories.MachineRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaintenanceActionMapper extends BaseMapper<MaintenanceAction, MaintenanceActionDTO> {
    @Autowired
    private  MachineRepository machineRepository;
    @Override
    public MaintenanceActionDTO fromEntity(MaintenanceAction entity) {
        MaintenanceActionDTO maintenanceActionDTO = new MaintenanceActionDTO();
        BeanUtils.copyProperties(entity, maintenanceActionDTO);
        maintenanceActionDTO.setMachineId((entity.getMachine().getId()));
        return maintenanceActionDTO;
    }

    @Override
    public MaintenanceAction fromDTO(MaintenanceActionDTO dto) {
        MaintenanceAction maintenanceAction = new MaintenanceAction();
        BeanUtils.copyProperties(dto, maintenanceAction);
        Machine machine = machineRepository.findById((dto.getMachineId()))
                .orElseThrow(() -> new RuntimeException("Machine not found with id " + dto.getMachineId()));
        maintenanceAction.setMachine(machine);
        return maintenanceAction;
    }
}
