package com.enset.maintenance_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="maintenance_actions")
@Data @NoArgsConstructor @AllArgsConstructor
public class MaintenanceAction extends BaseEntity {
    @Column(name="is_preventative")
    private Boolean isPreventive;
    private String description;
    private Double cost;
    @Column(name="action_date")
    private LocalDateTime actionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "machine_id")
    private Machine machine;
}
