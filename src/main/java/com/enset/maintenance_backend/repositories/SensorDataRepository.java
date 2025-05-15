package com.enset.maintenance_backend.repositories;

import com.enset.maintenance_backend.entities.SensorData;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SensorDataRepository extends BaseRepository<SensorData,Long> {
    @Query("SELECT sd FROM SensorData sd " +
            "WHERE sd.machine.id = :machineId " +
            "ORDER BY sd.createdAt DESC LIMIT :limit")
    List<SensorData> findLatestReadings(
            @Param("machineId") Long machineId,
            @Param("limit") int limit);

    @Modifying
    @Query("DELETE FROM SensorData sd " +
            "WHERE sd.createdAt < :cutoff AND sd.machine.id = :machineId")
    void purgeOldData(
            @Param("machineId") Long machineId,
            @Param("cutoff") LocalDateTime cutoff);
}
