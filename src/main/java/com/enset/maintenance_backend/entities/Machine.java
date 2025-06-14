package com.enset.maintenance_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="machines")
@Data @NoArgsConstructor @AllArgsConstructor
@Builder
public class Machine extends BaseEntity{
    private String name;
    private String serialNumber;
    @Column(name="expected_lifetime_hours")
    private float expectedLifetimeHours;

    @OneToMany(mappedBy = "machine",cascade = CascadeType.ALL)
    private List<SensorData> sensorData = new ArrayList<>();

    @OneToMany(mappedBy = "machine", cascade = CascadeType.ALL)
    private List<MaintenanceAction> maintenanceActions = new ArrayList<>();

    @OneToMany(mappedBy = "machine")
    private List<Prediction> predictions = new ArrayList<>();

    @OneToMany(mappedBy = "machine")
    private List<Failure> failures = new ArrayList<>();


}
