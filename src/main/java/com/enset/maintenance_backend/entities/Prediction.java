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
    private float predictedRulHours;
    private float confidence;
    @Column(name="fault_type")
    private String faultType;

    @ManyToOne
    private Machine machine;
}
