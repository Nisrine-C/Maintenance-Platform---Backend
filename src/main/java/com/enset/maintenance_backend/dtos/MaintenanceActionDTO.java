package com.enset.maintenance_backend.dtos;

import com.enset.maintenance_backend.entities.MaintenanceAction;
import lombok.Data;

import java.util.Date;

@Data
public class MaintenanceActionDTO extends BaseDTO{
    private Date actionDate;
    private String actionDescription;
    private Float cost;
    private Boolean isPreventive;
    private Long machineId;
}
