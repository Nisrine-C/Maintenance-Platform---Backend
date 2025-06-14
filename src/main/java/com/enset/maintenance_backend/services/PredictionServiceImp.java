package com.enset.maintenance_backend.services;

import com.enset.maintenance_backend.dtos.PredictionDTO;
import com.enset.maintenance_backend.entities.Prediction;
import com.enset.maintenance_backend.exceptions.PredictionNotFoundException;
import com.enset.maintenance_backend.mappers.PredictionMapper;
import com.enset.maintenance_backend.repositories.PredictionRepository;
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
public class PredictionServiceImp implements PredictionService {

    private final PredictionRepository predictionRepository;
    private final PredictionMapper predictionMapper;

    @Override
    public void deletePrediction(Long id) {
        predictionRepository.deleteById(id);

    }

    @Override
    public List<PredictionDTO> findAll() {
        List<Prediction> predictions = predictionRepository.findAll();
        List<PredictionDTO> predictionDTOS=predictions.stream()
                .map(prediction -> predictionMapper.fromEntity(prediction))
                .collect(Collectors.toList());
        return predictionDTOS;
    }

    @Override
    public PredictionDTO getEntityById(Long id) {
        Prediction prediction = predictionRepository.findById(id)
                .orElseThrow(() -> new PredictionNotFoundException("Prediction with ID " + id + " not found"));
        return predictionMapper.fromEntity(prediction);
    }

    @Override
    public PredictionDTO create(PredictionDTO dto) {
        log.info("Creating new prediction");
        Prediction prediction = predictionMapper.fromDTO(dto);
        prediction.setId(null);
        Prediction saved = predictionRepository.save(prediction);
        return predictionMapper.fromEntity(saved);
    }

    @Override
    public PredictionDTO update(Long id, PredictionDTO dto) {
        log.info("Updating prediction with ID: {}", id);
        Prediction prediction = predictionRepository.findById(id)
                .orElseThrow(() -> new PredictionNotFoundException("Prediction with ID " + id + " not found"));
        predictionMapper.updateEntityFromDTO(dto, prediction);
        Prediction updated = predictionRepository.save(prediction);
        log.info("Prediction with ID {} updated successfully", id);
        return predictionMapper.fromEntity(updated);
    }

    @Override
    public void softDelete(Long id) {
        Prediction prediction = predictionRepository.findById(id)
                .orElseThrow(() -> new PredictionNotFoundException("Prediction with ID " + id + " not found"));
        prediction.setIsActive(false);
        predictionRepository.save(prediction);
        log.info("Prediction with ID {} soft deleted (isActive = false)", id);
    }
}
