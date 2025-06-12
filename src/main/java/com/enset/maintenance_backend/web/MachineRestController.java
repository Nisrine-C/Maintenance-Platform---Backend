package com.enset.maintenance_backend.web;

import com.enset.maintenance_backend.dtos.GlobalStatsDto;
import com.enset.maintenance_backend.dtos.MachineDTO;
import com.enset.maintenance_backend.exceptions.MachineNotFoundException;
import com.enset.maintenance_backend.services.MachineService;
import com.enset.maintenance_backend.services.MachineServiceImp;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/")
@Slf4j

@CrossOrigin("*")

public class MachineRestController implements GenericController<MachineDTO, Long> {
    private MachineService machineService;
    private MachineServiceImp machineServiceImp;

    @Override
    @GetMapping("/machine")
    public List<MachineDTO> entities() {
        return machineService.findAll();
    }

    @Override
    @GetMapping("/machine/{id}")
    public MachineDTO getEntity(@PathVariable(name="id") Long id )throws MachineNotFoundException {
        return machineService.getEntityById(id);
    }

    @Override
    @PostMapping("/machine/")
    public MachineDTO save(@RequestBody MachineDTO machineDTO) {
        return machineService.create(machineDTO);
    }

    @Override
    @PostMapping("/machine/{id}")
    public MachineDTO update(@PathVariable Long id,@RequestBody MachineDTO machineDTO) {
        return machineService.update(id,machineDTO);
    }

    @Override
    @DeleteMapping("/machine/{id}")
    public void delete(@PathVariable Long id) {
        machineService.softDelete(id);
    }

//retourne les statistiques globales des machines
    @GetMapping("/stats/global")
    public GlobalStatsDto getGlobalStats() {
        return machineService.getGlobalStats();
    }
}
