package com.enset.maintenance_backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class HistogramBinDto {
    private String range;
    private long count;
}
