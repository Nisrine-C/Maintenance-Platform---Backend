package com.enset.maintenance_backend.services;

import com.enset.maintenance_backend.dtos.BaseDTO;
import com.enset.maintenance_backend.entities.BaseEntity;

import java.util.List;

public interface GenericService<DTO extends BaseDTO, E extends BaseEntity,ID> {
    List<DTO> findAll();

    DTO getEntityById(ID id);

    DTO create(DTO dto);

    DTO update(ID id, DTO dto);

    void softDelete(ID id);
}
