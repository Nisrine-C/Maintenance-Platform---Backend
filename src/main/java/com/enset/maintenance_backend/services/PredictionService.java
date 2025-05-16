package com.enset.maintenance_backend.services;

import com.enset.maintenance_backend.dtos.PredictionDTO;
import com.enset.maintenance_backend.entities.Prediction;

import java.rmi.Remote;

public interface PredictionService extends GenericService<PredictionDTO, Prediction, Long> {
    void deletePrediction(Long id);
}
