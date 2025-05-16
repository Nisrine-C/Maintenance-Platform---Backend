package com.enset.maintenance_backend.services;


import com.enset.maintenance_backend.dtos.FailureDTO;
import com.enset.maintenance_backend.entities.Failure;

public interface FailureService extends GenericService <FailureDTO, Failure,Long> {
    void deleteFailure(Long id);
}
