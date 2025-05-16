package com.enset.maintenance_backend.Repository;

import com.enset.maintenance_backend.Entities.MaintenanceAction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceActionRepository extends JpaRepository<MaintenanceAction, Long> {
}
