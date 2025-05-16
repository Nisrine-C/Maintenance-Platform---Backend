package com.enset.maintenance_backend.services;


import com.enset.maintenance_backend.dtos.MaintenanceActionDTO;
import com.enset.maintenance_backend.entities.MaintenanceAction;
import com.enset.maintenance_backend.exceptions.MaintenanceActionNotFoundException;
import com.enset.maintenance_backend.mappers.MaintenanceActionMapper;
import com.enset.maintenance_backend.repositories.MaintenanceActionRepository;
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
public class MachineActionServiceImp implements MachineActionService {
    private  MaintenanceActionMapper maintenanceActionMapper;
    private MaintenanceActionRepository maintenanceActionRepository;

    @Override
    public void deleteMaintenanceAction(Long id) {
        maintenanceActionRepository.deleteById(id);
    }

    @Override
    public List<MaintenanceActionDTO> findAll() {
        List<MaintenanceAction> maintenanceActions = maintenanceActionRepository.findAll();
        List<MaintenanceActionDTO> maintenanceActionDTOs = maintenanceActions.stream()
                .map(maintenanceAction -> maintenanceActionMapper.fromEntity(maintenanceAction))
                .collect(Collectors.toList());
        return maintenanceActionDTOs;
    }

    @Override
    public MaintenanceActionDTO getEntityById(Long id) {
        MaintenanceAction maintenanceAction = maintenanceActionRepository.findById(id)
                .orElseThrow(() -> new MaintenanceActionNotFoundException("Maintenance Action Not Found"));
        return maintenanceActionMapper.fromEntity(maintenanceAction);
    }

    @Override
    public MaintenanceActionDTO create(MaintenanceActionDTO dto) {
        log.info("Create MaintenanceAction");
        MaintenanceAction maintenanceAction = maintenanceActionMapper.fromDTO(dto);
        MaintenanceAction savedMaintenanceAction = maintenanceActionRepository.save(maintenanceAction);
        return maintenanceActionMapper.fromEntity(savedMaintenanceAction);
    }

    @Override
    public MaintenanceActionDTO update(Long id, MaintenanceActionDTO maintenanceActionDTO) {
        log.info("Updating machine with ID: {}", id);

        MaintenanceAction maintenanceAction = maintenanceActionRepository.findById(id)
                .orElseThrow(() -> new MaintenanceActionNotFoundException("Maintenance Action with ID " + id + " not found"));
        if (maintenanceActionDTO == null) {
            throw new IllegalArgumentException("MaintenanceActionDTO cannot be null");
        }
        maintenanceActionMapper.updateEntityFromDTO(maintenanceActionDTO, maintenanceAction);
        MaintenanceAction updatedMaintenace = maintenanceActionRepository.save(maintenanceAction);
        log.info("Maintenance Action with ID {} updated successfully", id);
        return maintenanceActionMapper.fromEntity(updatedMaintenace);
    }

    @Override
    public void softDelete(Long id) {
        MaintenanceAction maintenanceAction = maintenanceActionRepository.findById(id).
                orElseThrow(()-> new MaintenanceActionNotFoundException("Maintenance Action not found"));
        maintenanceAction.setIsActive(false);
        maintenanceActionRepository.save(maintenanceAction);

    }
}
