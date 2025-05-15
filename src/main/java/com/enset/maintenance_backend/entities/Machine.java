package com.enset.maintenance_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="machines")
@Data @NoArgsConstructor @AllArgsConstructor
public class Machine extends BaseEntity{
    private String name;
    private String serialNumber;

    @OneToMany(mappedBy = "machine",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<SensorData> sensorData = new ArrayList<>();

    @OneToMany(mappedBy = "machine")
    private List<MaintenanceAction> maintenanceActions = new ArrayList<>();

    @OneToMany(mappedBy = "machine")
    private List<Prediction> predictions = new ArrayList<>();
}
