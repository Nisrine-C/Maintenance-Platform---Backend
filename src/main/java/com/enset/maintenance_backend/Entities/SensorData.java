package com.enset.maintenance_backend.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Builder
public class SensorData {
    @Id
    @GeneratedValue
    private Long id;

    private Date recordedAt;
    private Float vibrationX, vibrationY, vibrationZ;
    private Float speedSet, loadValue;

    @ManyToOne
    private Machine machine;
}
