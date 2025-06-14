package com.enset.maintenance_backend.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FailureDTO extends BaseDTO {
    private Long machineId;
    private float downtimeHours;
    private String faultType;
}
