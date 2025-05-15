package com.enset.maintenance_backend.repositories;

import com.enset.maintenance_backend.entities.MaintenanceAction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MaintenanceActionRepository extends BaseRepository<MaintenanceAction,Long>{
    List<MaintenanceAction> findByIsPreventiveAndMachineId(
            Boolean isPreventive,
            Long machineId);
    @Query("SELECT SUM(m.cost) FROM MaintenanceAction m " +
            "WHERE m.machine.id = :machineId AND m.actionDate BETWEEN :start AND :end")
    Double calculateMaintenanceCost(
            @Param("machineId") Long machineId,
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end);
}
