package com.enset.maintenance_backend.repositories;

import com.enset.maintenance_backend.entities.BaseEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, ID> extends JpaRepository<T,ID> {
    @Modifying
    @Transactional
    @Query("UPDATE #{#entityName} e SET e.isActive = false WHERE e.id = ?1")
    void softDelete(ID id);

    @Query("SELECT e FROM #{#entityName} e WHERE e.isActive = true")
    List<T> findAllActive();
}
