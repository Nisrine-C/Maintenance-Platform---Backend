package com.enset.maintenance_backend.web;

import com.enset.maintenance_backend.dtos.MaintenanceActionDTO;
import com.enset.maintenance_backend.services.MachineActionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenance-actions")
@AllArgsConstructor
@CrossOrigin("*")
public class MaintenanceActionController implements GenericController<MaintenanceActionDTO, Long> {

    private final MachineActionService machineActionService;

    @Override
    @GetMapping("/maintenance")
    public List<MaintenanceActionDTO> entities() {
        return machineActionService.findAll();
    }

    @Override
    @GetMapping("/maintenance/{id}")
    public MaintenanceActionDTO getEntity(@PathVariable Long id) {
        return machineActionService.getEntityById(id);
    }

    @Override
    @PostMapping("/maintenance")
    public MaintenanceActionDTO save(@RequestBody MaintenanceActionDTO entityDTO) {
        return machineActionService.create(entityDTO);
    }

    @Override
    @PutMapping("/maintenance/{id}")
    public MaintenanceActionDTO update(@PathVariable Long id, @RequestBody MaintenanceActionDTO entityDTO) {
        return machineActionService.update(id, entityDTO);
    }

    @Override
    @DeleteMapping("/maintenance/{id}")
    public void delete(@PathVariable Long id) {
        machineActionService.softDelete(id); // ou machineActionService.deleteMaintenanceAction(id);
    }
}
