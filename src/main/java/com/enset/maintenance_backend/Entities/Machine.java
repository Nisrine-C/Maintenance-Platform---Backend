package com.enset.maintenance_backend.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Date;
import java.util.List;

@Data
@Entity @NoArgsConstructor @AllArgsConstructor @Builder
public class Machine {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Date installationDate ;
    private Float expectedLifetimeHours;

    @OneToMany(mappedBy = "machine", cascade = CascadeType.ALL)
    private List<SensorData> sensorData;

    @OneToMany(mappedBy = "machine", cascade = CascadeType.ALL)
    private List<MaintenanceAction> maintenanceActions;

}
