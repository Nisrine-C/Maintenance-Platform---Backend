package com.enset.maintenance_backend.services;

import com.enset.maintenance_backend.dtos.MachineDTO;
import com.enset.maintenance_backend.dtos.GlobalStatsDto;
import com.enset.maintenance_backend.entities.Machine;
import com.enset.maintenance_backend.exceptions.MachineNotFoundException;
import com.enset.maintenance_backend.mappers.MachineMapper;
import com.enset.maintenance_backend.repositories.*;
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
public class MachineServiceImp implements MachineService{
    private MachineRepository machineRepository;
    private MaintenanceActionRepository maintenanceActionRepository;
    private SensorDataRepository sensorDataRepository;
    private MachineMapper machineMapper;
    private PredictionRepository predictionRepository;
    private FailureRepository failureRepository;


    @Override
    public void deleteMachine(Long id) {
        machineRepository.deleteById(id);
    }

    @Override
    public List<MachineDTO> findAll() {
        List<Machine> machines = machineRepository.findAll();
        List<MachineDTO> machineDTOS = machines.stream()
                .map(machine -> machineMapper.fromEntity(machine))
                .collect(Collectors.toList());
        return machineDTOS;
    }

    @Override
    public MachineDTO getEntityById(Long id) {
        Machine machine = machineRepository.findById(id)
                .orElseThrow(() -> new MachineNotFoundException("Machine Not found"));
        return machineMapper.fromEntity(machine);
    }

    @Override
    public MachineDTO create(MachineDTO machineDTO) {
        log.info("Create machine");
        Machine machine1=machineMapper.fromDTO(machineDTO);
        Machine saveMachine = machineRepository.save(machine1);
        return machineMapper.fromEntity(saveMachine);
    }

    @Override
    public MachineDTO update(Long id, MachineDTO machineDTO) {
        log.info("Updating machine with ID: {}", id);

        Machine existingMachine = machineRepository.findById(id)
                .orElseThrow(() -> new MachineNotFoundException("Machine with ID " + id + " not found"));
        if (machineDTO == null) {
            throw new IllegalArgumentException("MachineDTO cannot be null");
        }
        machineMapper.updateEntityFromDTO(machineDTO, existingMachine);
        Machine updatedMachine = machineRepository.save(existingMachine);
        log.info("Machine with ID {} updated successfully", id);
        return machineMapper.fromEntity(updatedMachine);
    }

    @Override
    public void softDelete(Long id) {
        Machine machine = machineRepository.findById(id).
                orElseThrow(()-> new MachineNotFoundException("Machine not found"));
        machine.setIsActive(false);
        machineRepository.save(machine);
    }

    public GlobalStatsDto getGlobalStats() {
        long total = machineRepository.count();

        long predictedFaults = predictionRepository.countByConfidenceGreaterThan(0.8f); // par exemple
        long nearEndOfLife = predictionRepository.countByPredictedRulHoursLessThan(100); // par exemple < 100h
        long active = machineRepository.countByIsActiveTrue();
        return new GlobalStatsDto(total, predictedFaults, nearEndOfLife, active);

    }
}
