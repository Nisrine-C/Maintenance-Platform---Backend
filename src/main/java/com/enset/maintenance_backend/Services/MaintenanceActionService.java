package com.enset.maintenance_backend.Services;

import com.enset.maintenance_backend.DTOs.MaintenanceActionDTO;

import java.util.List;

public interface MaintenanceActionService {
    List<MaintenanceActionDTO> getAllActions();
    MaintenanceActionDTO getActionById(Long id);
    MaintenanceActionDTO createAction(MaintenanceActionDTO action, Integer machineId);
    MaintenanceActionDTO updateAction(Integer id, MaintenanceActionDTO action);
    List<MaintenanceActionDTO> getActionsByMachineId(Long machineId);
    List<MaintenanceActionDTO> getPreventiveActions(Long machineId);
    float calculateTotalMaintenanceCost(Long machineId);
}
