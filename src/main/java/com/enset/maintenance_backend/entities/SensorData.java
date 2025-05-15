package com.enset.maintenance_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "sensor_data")
@Data @NoArgsConstructor @AllArgsConstructor
public class SensorData extends BaseEntity{
    private Double vibrationX;
    private Double vibrationY;
    private Double temperature;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name= "machine_id")
    private Machine machine;
}
