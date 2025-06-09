package com.enset.maintenance_backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class GlobalStatsDto {
    private long total;
    private long predictedFaults;
    private long nearEndOfLife;
    private long active;
}
