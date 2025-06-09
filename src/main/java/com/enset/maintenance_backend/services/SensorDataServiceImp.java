package com.enset.maintenance_backend.services;

import com.enset.maintenance_backend.dtos.HistogramBinDto;
import com.enset.maintenance_backend.dtos.SensorDataDTO;
import com.enset.maintenance_backend.dtos.VibrationTrendDto;
import com.enset.maintenance_backend.entities.SensorData;
import com.enset.maintenance_backend.exceptions.SensorDataNotFoundException;

import com.enset.maintenance_backend.mappers.SensorDataMapper;
import com.enset.maintenance_backend.repositories.SensorDataRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class SensorDataServiceImp implements SensorDataService {

    private  SensorDataRepository sensorDataRepository;
    private SensorDataMapper sensorDataMapper;

    @Override
    public void deleteSensorData(Long id) {
        sensorDataRepository.deleteById(id);
    }

    @Override
    public List<SensorDataDTO> findAll() {
        List<SensorData> sensorDataList = sensorDataRepository.findAll();
        List<SensorDataDTO> sensorDataDTOS = sensorDataList.stream()
                .map(sensorData -> sensorDataMapper.fromEntity(sensorData))
                .collect(Collectors.toList());
        return sensorDataDTOS;
    }

    @Override
    public SensorDataDTO getEntityById(Long id) {
        SensorData sensorData = sensorDataRepository.findById(id)
                .orElseThrow(() -> new SensorDataNotFoundException("Sensor data with ID " + id + " not found"));
        return sensorDataMapper.fromEntity(sensorData);
    }

    @Override
    public SensorDataDTO create(SensorDataDTO dto) {
        log.info("Creating new sensor data");
        SensorData sensorData = sensorDataMapper.fromDTO(dto);
        SensorData saved = sensorDataRepository.save(sensorData);
        return sensorDataMapper.fromEntity(saved);
    }

    @Override
    public SensorDataDTO update(Long id, SensorDataDTO dto) {
        log.info("Updating sensor data with ID: {}", id);
        SensorData sensorData = sensorDataRepository.findById(id)
                .orElseThrow(() -> new SensorDataNotFoundException("Sensor data with ID " + id + " not found"));
        sensorDataMapper.updateEntityFromDTO(dto, sensorData);
        SensorData updated = sensorDataRepository.save(sensorData);
        log.info("Sensor data with ID {} updated successfully", id);
        return sensorDataMapper.fromEntity(updated);
    }

    @Override
    public void softDelete(Long id) {
        SensorData sensorData = sensorDataRepository.findById(id)
                .orElseThrow(() -> new SensorDataNotFoundException("Sensor data with ID " + id + " not found"));
        sensorData.setIsActive(false);
        sensorDataRepository.save(sensorData);
        log.info("Sensor data with ID {} soft deleted (isActive set to false)", id);
    }


    public List<VibrationTrendDto> getVibrationTrends(Long machineId) {
        List<SensorData> data = sensorDataRepository.findByMachineIdOrderByCreatedAtAsc(machineId);
        return data.stream()
                .map(d -> new VibrationTrendDto(d.getCreatedAt(), d.getVibrationX(), d.getVibrationY()))
                .collect(Collectors.toList());
    }

    public List<HistogramBinDto> getVibrationHistogram(Long machineId, double binSize) {
        List<SensorData> data = sensorDataRepository.findByMachineIdOrderByCreatedAtAsc(machineId);

        // On ne considère que vibrationX ici. Tu peux faire pour Y aussi.
        List<Double> vibrations = data.stream()
                .map(SensorData::getVibrationX)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        // Trouver min et max
        double min = vibrations.stream().min(Double::compare).orElse(0.0);
        double max = vibrations.stream().max(Double::compare).orElse(0.0);

        int numBins = (int) Math.ceil((max - min) / binSize);

        Map<String, Long> bins = new LinkedHashMap<>();

        for (int i = 0; i < numBins; i++) {
            double start = min + i * binSize;
            double end = start + binSize;
            String label = String.format("%.1f - %.1f", start, end);
            bins.put(label, 0L);
        }

        for (Double value : vibrations) {
            int binIndex = (int) ((value - min) / binSize);
            binIndex = Math.min(binIndex, numBins - 1); // sécurité
            double start = min + binIndex * binSize;
            double end = start + binSize;
            String label = String.format("%.1f - %.1f", start, end);
            bins.put(label, bins.get(label) + 1);
        }

        return bins.entrySet().stream()
                .map(e -> new HistogramBinDto(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }


}
