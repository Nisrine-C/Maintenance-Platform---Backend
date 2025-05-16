package com.enset.maintenance_backend.mappers;

import com.enset.maintenance_backend.dtos.FailureDTO;
import com.enset.maintenance_backend.entities.Failure;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class FailureMapper extends BaseMapper<Failure, FailureDTO> {
    @Override
    public FailureDTO fromEntity(Failure entity) {
       FailureDTO failureDTO = new FailureDTO();
        BeanUtils.copyProperties(entity, failureDTO);
        return failureDTO;

    }

    @Override
    public Failure fromDTO(FailureDTO dto) {
        Failure failure = new Failure();
        BeanUtils.copyProperties(dto, failure);
        return failure;
    }
}
