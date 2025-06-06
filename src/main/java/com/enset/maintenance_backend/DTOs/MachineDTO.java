package com.enset.maintenance_backend.DTOs;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MachineDTO {
    private Integer id;
    private String name;
    private String serialNumber;
    private Date installationDate;
    private Float expectedLifetimeHours;
    private Boolean isActive= true;
    List<SensorDataDTO> sensorDataDTOS;
    List<MaintenanceActionDTO> maintenanceActions;
}
