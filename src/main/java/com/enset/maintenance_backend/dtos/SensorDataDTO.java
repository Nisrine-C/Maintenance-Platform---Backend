package com.enset.maintenance_backend.dtos;

import lombok.Data;

@Data
public class SensorDataDTO extends BaseDTO{
    private Float vibrationX;
    private Float vibrationY;
    private Float speedSet;
    private Float loadValue;
    private Integer machineId;
}
