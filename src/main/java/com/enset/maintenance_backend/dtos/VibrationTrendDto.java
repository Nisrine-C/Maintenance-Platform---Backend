package com.enset.maintenance_backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data @AllArgsConstructor
public class VibrationTrendDto {
    private Date timestamp;
    private Float vibrationX;
    private Float vibrationY;
}
