package com.enset.maintenance_backend.mappers;

import com.enset.maintenance_backend.dtos.PredictionDTO;
import com.enset.maintenance_backend.entities.Machine;
import com.enset.maintenance_backend.entities.Prediction;
import com.enset.maintenance_backend.repositories.MachineRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PredictionMapper extends BaseMapper<Prediction, PredictionDTO> {
    @Autowired
    private MachineRepository machineRepository;
    @Override
    public PredictionDTO fromEntity(Prediction entity) {
        PredictionDTO predictionDTO = new PredictionDTO();
        BeanUtils.copyProperties(entity, predictionDTO);
        //predictionDTO.setMachineId((entity.getMachine().getId()));
        return predictionDTO;
    }

    @Override
    public Prediction fromDTO(PredictionDTO dto) {
       Prediction prediction = new Prediction();
       BeanUtils.copyProperties(dto, prediction);
//        Machine machine = machineRepository.findById((dto.getMachineId()))
//                .orElseThrow(() -> new RuntimeException("Machine not found with id " + dto.getMachineId()));
//        prediction.setMachine(machine);
       return prediction;
    }
}
