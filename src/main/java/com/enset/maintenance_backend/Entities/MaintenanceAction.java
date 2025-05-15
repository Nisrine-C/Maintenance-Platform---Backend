package com.enset.maintenance_backend.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class MaintenanceAction {
    @Id
    @GeneratedValue
    private Integer id;

    private LocalDateTime actionDate;
    private String actionDescription;
    private Float cost;
    private Boolean isPreventive;
    @ManyToOne
    private Machine machine;
}
