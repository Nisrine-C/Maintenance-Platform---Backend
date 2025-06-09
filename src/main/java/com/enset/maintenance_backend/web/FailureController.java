package com.enset.maintenance_backend.web;


import com.enset.maintenance_backend.dtos.FailureDTO;
import com.enset.maintenance_backend.entities.Failure;
import com.enset.maintenance_backend.services.FailureService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/failures")
@AllArgsConstructor

@CrossOrigin("*")
public class FailureController implements GenericController<FailureDTO, Long> {

    private final FailureService failureService;

    @Override
    @GetMapping("/failure")
    public List<FailureDTO> entities() {
        return failureService.findAll();
    }

    @Override
    @GetMapping("/failure/{id}")
    public FailureDTO getEntity(@PathVariable Long id) {
        return failureService.getEntityById(id);
    }

    @Override
    @PostMapping("/failure")
    public FailureDTO save(@RequestBody FailureDTO entityDTO) {
        return failureService.create(entityDTO);
    }

    @Override
    @PutMapping("/failure/{id}")
    public FailureDTO update(@PathVariable Long id, @RequestBody FailureDTO entityDTO) {
        return failureService.update(id, entityDTO);
    }

    @Override
    @DeleteMapping("/failure/{id}")
    public void delete(@PathVariable Long id) {
        failureService.softDelete(id);
    }

    @GetMapping("/latest/alerts")
    public ResponseEntity<List<FailureDTO>> getLatestFailures(
            @RequestParam(defaultValue = "5") int limit
    ) {
        return ResponseEntity.ok(failureService.getLatestFailureAlerts(limit));
    }
}
