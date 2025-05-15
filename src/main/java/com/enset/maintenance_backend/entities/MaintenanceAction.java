package com.enset.maintenance_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="maintenance_actions")
@Data @NoArgsConstructor @AllArgsConstructor
@Builder
public class MaintenanceAction extends BaseEntity {
    @Column(name="is_preventive")
    private Boolean isPreventive;
    @Column(name="action_description")
    private String actionDescription;
    private float cost;
    @Column(name="action_date")
    private Date actionDate;

    @ManyToOne
    private Machine machine;
}
