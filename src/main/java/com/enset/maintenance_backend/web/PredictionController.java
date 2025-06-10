package com.enset.maintenance_backend.web;

import com.enset.maintenance_backend.dtos.PredictionDTO;
import com.enset.maintenance_backend.services.PredictionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class PredictionController {

    private final PredictionService predictionService;

    @GetMapping("/prediction")
    public List<PredictionDTO> getAllPredictions() {
        return predictionService.findAll();
    }

    @GetMapping("/prediction/{id}")
    public PredictionDTO getPredictionById(@PathVariable Long id) {
        return predictionService.getEntityById(id);
    }

    @PostMapping("/prediction")
    public PredictionDTO createPrediction(@RequestBody PredictionDTO dto) {
        return predictionService.create(dto);
    }

    @PutMapping("/prediction/{id}")
    public PredictionDTO updatePrediction(@PathVariable Long id, @RequestBody PredictionDTO dto) {
        return predictionService.update(id, dto);
    }

    @DeleteMapping("/prediction/{id}")
    public void deletePrediction(@PathVariable Long id) {
        predictionService.deletePrediction(id);
    }

    @PatchMapping("/prediction/{id}/soft-delete")
    public void softDeletePrediction(@PathVariable Long id) {
        predictionService.softDelete(id);
    }
}
