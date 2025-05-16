package com.enset.maintenance_backend.services;

import com.enset.maintenance_backend.dtos.FailureDTO;
import com.enset.maintenance_backend.entities.Failure;
import com.enset.maintenance_backend.exceptions.FailureNotFoundException;
import com.enset.maintenance_backend.mappers.FailureMapper;
import com.enset.maintenance_backend.repositories.FailureRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class FailureServiceImp implements FailureService {

    private final FailureRepository failureRepository;
    private final FailureMapper failureMapper;

    @Override
    public void deleteFailure(Long id) {
        failureRepository.deleteById(id);

    }

    @Override
    public List<FailureDTO> findAll() {
        List<Failure> failures = failureRepository.findAll();
        List<FailureDTO> failureDTOS =failures.stream()
                .map(failure -> failureMapper.fromEntity(failure))
                .collect(Collectors.toList());
        return failureDTOS;
    }

    @Override
    public FailureDTO getEntityById(Long id) {
        Failure failure = failureRepository.findById(id)
                .orElseThrow(() -> new FailureNotFoundException("Failure with ID " + id + " not found"));
        return failureMapper.fromEntity(failure);
    }

    @Override
    public FailureDTO create(FailureDTO dto) {
        log.info("Creating new failure record");
        Failure failure = failureMapper.fromDTO(dto);
        Failure saved = failureRepository.save(failure);
        return failureMapper.fromEntity(saved);
    }

    @Override
    public FailureDTO update(Long id, FailureDTO dto) {
        log.info("Updating failure with ID: {}", id);
        Failure failure = failureRepository.findById(id)
                .orElseThrow(() -> new FailureNotFoundException("Failure with ID " + id + " not found"));
        failureMapper.updateEntityFromDTO(dto, failure);
        Failure updated = failureRepository.save(failure);
        log.info("Failure with ID {} updated successfully", id);
        return failureMapper.fromEntity(updated);
    }

    @Override
    public void softDelete(Long id) {
        Failure failure = failureRepository.findById(id)
                .orElseThrow(() -> new FailureNotFoundException("Failure with ID " + id + " not found"));
        failure.setIsActive(false);
        failureRepository.save(failure);
        log.info("Failure with ID {} soft deleted (isActive set to false)", id);
    }
}
