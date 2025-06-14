package com.enset.maintenance_backend.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SensorDataDTO extends BaseDTO{
    private Float vibrationX;
    private Float vibrationY;
    private Float speedSet;
    private Float loadValue;
    private Long machineId;
}
