package com.enset.maintenance_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "failures")
@Data @AllArgsConstructor @NoArgsConstructor
public class Failure extends BaseEntity{
    @Column(name="downtime_hours")
    private float downtimeHours;
    @Column(name="fault_type")
    private String faultType;

    @ManyToOne
    private Machine machine;

}
