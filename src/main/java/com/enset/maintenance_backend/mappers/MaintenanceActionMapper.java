package com.enset.maintenance_backend.mappers;


import com.enset.maintenance_backend.dtos.MaintenanceActionDTO;
import com.enset.maintenance_backend.entities.MaintenanceAction;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MaintenanceActionMapper extends BaseMapper<MaintenanceAction, MaintenanceActionDTO> {
    @Override
    public MaintenanceActionDTO fromEntity(MaintenanceAction entity) {
        MaintenanceActionDTO maintenanceActionDTO = new MaintenanceActionDTO();
        BeanUtils.copyProperties(entity, maintenanceActionDTO);
        return maintenanceActionDTO;
    }

    @Override
    public MaintenanceAction fromDTO(MaintenanceActionDTO dto) {
        MaintenanceAction maintenanceAction = new MaintenanceAction();
        BeanUtils.copyProperties(dto, maintenanceAction);
        return maintenanceAction;
    }
}
