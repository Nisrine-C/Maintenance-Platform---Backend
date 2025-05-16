package com.enset.maintenance_backend.mappers;

import com.enset.maintenance_backend.dtos.PredictionDTO;
import com.enset.maintenance_backend.entities.Prediction;
import org.springframework.beans.BeanUtils;

public class PredictionMapper extends BaseMapper<Prediction, PredictionDTO> {
    @Override
    public PredictionDTO fromEntity(Prediction entity) {
        PredictionDTO predictionDTO = new PredictionDTO();
        BeanUtils.copyProperties(entity, predictionDTO);
        return predictionDTO;
    }

    @Override
    public Prediction fromDTO(PredictionDTO dto) {
       Prediction prediction = new Prediction();
       BeanUtils.copyProperties(dto, prediction);
       return prediction;
    }
}
