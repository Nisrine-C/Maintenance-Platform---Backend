package com.enset.maintenance_backend.Repository;

import com.enset.maintenance_backend.Entities.Machine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MachineRepository extends JpaRepository<Machine, Long> {
}
