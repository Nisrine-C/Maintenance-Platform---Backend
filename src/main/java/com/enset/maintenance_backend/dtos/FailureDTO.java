package com.enset.maintenance_backend.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @AllArgsConstructor @NoArgsConstructor
public class FailureDTO extends BaseDTO {
    private  String machineName;
    private float downtimeHours;
    private String faultType;

    public FailureDTO(Long id, String faultType, float downtimeHours, String name, LocalDateTime createdAt) {
        super();
    }
}
