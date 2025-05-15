package com.enset.maintenance_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="predictions")
@Data @AllArgsConstructor @NoArgsConstructor
public class Prediction extends BaseEntity{
    @Column(name = "predicted_rul_hours")
    private Double predictedRulHours;
    private Double confidence;
    private String faultType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="machine_id")
    private Machine machine;
}
