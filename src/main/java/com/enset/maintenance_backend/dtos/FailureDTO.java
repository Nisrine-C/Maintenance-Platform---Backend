package com.enset.maintenance_backend.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class FailureDTO extends BaseDTO {
    private Long machineId;
    private Float downtimeHours;
    private String faultType;


    public FailureDTO(){
    }

    public FailureDTO(Long id, String faultType, float downtimeHours,Date createdAt, Boolean isActive, Long machineId) {
        this.setId(id);
        this.faultType = faultType;
        this.downtimeHours = downtimeHours;
        this.setCreatedAt(createdAt);
        this.setIsActive(isActive);
        this.machineId = machineId;
    }
}
