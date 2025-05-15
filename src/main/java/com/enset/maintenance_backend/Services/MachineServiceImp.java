package com.enset.maintenance_backend.Services;

import com.enset.maintenance_backend.DTOs.MachineDTO;
import com.enset.maintenance_backend.DTOs.MaintenanceActionDTO;
import com.enset.maintenance_backend.DTOs.SensorDataDTO;
import com.enset.maintenance_backend.Entities.Machine;
import com.enset.maintenance_backend.Exceptions.MachineNotFoundException;
import com.enset.maintenance_backend.Mappers.MachineMapper;
import com.enset.maintenance_backend.Repository.MachineRepository;
import com.enset.maintenance_backend.Repository.MaintenanceActionRepository;
import com.enset.maintenance_backend.Repository.SensorDataRepository;
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
public class MachineServiceImp implements MachineService {
    private  MachineRepository machineRepository;
    private  MaintenanceActionRepository maintenanceActionRepository;
    private SensorDataRepository sensorDataRepository;
    private MachineMapper machineMapper;

    @Override
    public List<MachineDTO> getAllMachines() {
        List<Machine> machines = machineRepository.findAll();
        List<MachineDTO> machineDTOS = machines.stream()
                .map(machine -> machineMapper.fromMachine(machine))
                .collect(Collectors.toList());
        return machineDTOS;
    }

    @Override
    public MachineDTO getMachineById(Long id) {
        Machine machine = machineRepository.findById(id)
                .orElseThrow(() -> new MachineNotFoundException("Machine Not found"));
        return machineMapper.fromMachine(machine);
    }

    @Override
    public MachineDTO createMachine(MachineDTO machine) {
        log.info("Create machine");
        Machine machine1=machineMapper.fromMachineDTO(machine);
        Machine saveMachine = machineRepository.save(machine1);
        return machineMapper.fromMachine(saveMachine);
    }

    @Override
    public MachineDTO updateMachine(Long id, MachineDTO machineDTO) {
        log.info("Updating machine with ID: {}", id);

        Machine existingMachine = machineRepository.findById(id)
                .orElseThrow(() -> new MachineNotFoundException("Machine with ID " + id + " not found"));
        if (machineDTO == null) {
            throw new IllegalArgumentException("MachineDTO cannot be null");
        }
        machineMapper.updateMachineFromDTO(machineDTO, existingMachine);

        // 4. Applique les changements en base
        Machine updatedMachine = machineRepository.save(existingMachine);

        // 5. Log et retourne le résultat
        log.info("Machine with ID {} updated successfully", id);
        return machineMapper.fromMachine(updatedMachine);

    }

    @Override
    public void deleteMachine(Long id) {
        Machine machine = machineRepository.findById(id)
                .orElseThrow(() -> new MachineNotFoundException("Machine Not Found"));
        machine.setIsActive(false); // Soft deletion
        machineRepository.save(machine);
    }


}
