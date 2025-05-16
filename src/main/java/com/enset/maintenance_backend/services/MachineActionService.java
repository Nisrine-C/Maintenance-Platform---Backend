package com.enset.maintenance_backend.services;

import com.enset.maintenance_backend.dtos.MaintenanceActionDTO;
import com.enset.maintenance_backend.entities.MaintenanceAction;

public interface MachineActionService extends GenericService <MaintenanceActionDTO, MaintenanceAction,Long> {
   void deleteMaintenanceAction(Long id);
}
