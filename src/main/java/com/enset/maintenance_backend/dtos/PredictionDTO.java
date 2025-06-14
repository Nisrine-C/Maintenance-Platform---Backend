package com.enset.maintenance_backend.dtos;

import com.enset.maintenance_backend.entities.Machine;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PredictionDTO extends BaseDTO {
    private Long machineId;
    private float predictedRulHours;
    private float confidence;
    private String faultType;

}
