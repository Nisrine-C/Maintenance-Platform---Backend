package com.enset.maintenance_backend.dtos;


import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MachineDTO extends BaseDTO{
    private String name;
    private String serialNumber;
    private Float expectedLifetimeHours;
    List<SensorDataDTO> sensorDataDTOS;
    List<MaintenanceActionDTO> maintenanceActions;
    List<PredictionDTO> predictions;
    List<FailureDTO> failures;
}
