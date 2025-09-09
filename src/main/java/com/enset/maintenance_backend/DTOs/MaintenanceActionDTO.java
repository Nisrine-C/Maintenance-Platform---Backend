package com.enset.maintenance_backend.DTOs;

import lombok.Data;

import java.util.Date;

@Data
public class MaintenanceActionDTO {
    private Integer id;
    private Date actionDate;
    private String actionDescription;
    private Float cost;
    private Boolean isPreventive;
    private Integer machineId;
}
