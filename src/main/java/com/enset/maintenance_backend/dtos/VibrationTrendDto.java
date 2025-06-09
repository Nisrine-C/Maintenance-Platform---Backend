package com.enset.maintenance_backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Data @AllArgsConstructor
public class VibrationTrendDto {
    private LocalDateTime timestamp;
    private Double vibrationX;
    private Double vibrationY;
}
