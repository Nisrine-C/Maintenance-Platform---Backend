package com.enset.maintenance_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "sensor_data")
@Data @NoArgsConstructor @AllArgsConstructor
@Builder
public class SensorData extends BaseEntity{
    @Column(name="vibration_x")
    private Float vibrationX;
    @Column(name="vibration_y")
    private Float vibrationY;
    @Column(name="speed_set")
    private Float speedSet;
    @Column(name="load_value")
    private Float loadValue;

    @ManyToOne
    private Machine machine;
}
