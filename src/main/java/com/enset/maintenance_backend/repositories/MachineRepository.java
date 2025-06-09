package com.enset.maintenance_backend.repositories;

import com.enset.maintenance_backend.entities.Machine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineRepository extends BaseRepository<Machine,Long>{
    Page<Machine> findByNameContaining(String name, Pageable pageable);
//
long countByIsActiveTrue();
}
