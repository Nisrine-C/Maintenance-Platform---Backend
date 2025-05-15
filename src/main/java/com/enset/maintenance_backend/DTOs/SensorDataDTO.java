package com.enset.maintenance_backend.DTOs;

import lombok.Data;

import java.util.Date;

@Data
public class SensorDataDTO {
    private Integer id;
    private Date recordedAt;
    private Float vibrationX;
    private Float vibrationY;
    private Float speedSet;
    private Float loadValue;
    private Integer machineId;
}
