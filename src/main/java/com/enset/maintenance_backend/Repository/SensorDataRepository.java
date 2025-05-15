package com.enset.maintenance_backend.Repository;

import com.enset.maintenance_backend.Entities.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.beans.JavaBean;

public interface SensorDataRepository extends JpaRepository<SensorData, Long> {
}
