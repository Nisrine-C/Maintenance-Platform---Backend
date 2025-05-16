package com.enset.maintenance_backend.mappers;

import com.enset.maintenance_backend.dtos.BaseDTO;
import com.enset.maintenance_backend.entities.BaseEntity;


public abstract class BaseMapper<E extends BaseEntity,DTO extends BaseDTO> {

    public abstract DTO fromEntity(E entity);

    public abstract E fromDTO(DTO dto);

    public void updateEntityFromDTO(DTO dto, E entity) {
        if (dto.getId() != null && !dto.getId().equals(entity.getId())) {
            throw new IllegalArgumentException("IDs must match for update");
        }
        entity.setId(dto.getId());
    }

}
