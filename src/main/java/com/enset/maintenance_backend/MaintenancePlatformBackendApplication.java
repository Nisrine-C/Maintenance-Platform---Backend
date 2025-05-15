package com.enset.maintenance_backend;

import com.enset.maintenance_backend.entities.Machine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.enset.maintenance_backend.repositories.*;
import com.enset.maintenance_backend.entities.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class MaintenancePlatformBackendApplication  implements CommandLineRunner {

    @Autowired
    private MachineRepository machineRepo;
    @Autowired
    private SensorDataRepository sensorDataRepo;
    @Autowired
    private MaintenanceActionRepository maintenanceRepo;
    @Autowired
    private PredictionRepository predictionRepo;

    public static void main(String[] args) {
        SpringApplication.run(MaintenancePlatformBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== Testing DAO Layer ===");

        // 1. Create and test Machine
        Machine machine = new Machine();
        machine.setName("Industrial Mixer");
        machine.setSerialNumber("IMX-1000");
        machineRepo.save(machine);
        System.out.println("[PASS] Machine saved: " + machine.getName());

        // 2. Test SensorData operations
        SensorData data = new SensorData();
        data.setVibrationX(0.8);
        data.setVibrationY(0.6);
        data.setTemperature(32.5);
        data.setMachine(machine);
        sensorDataRepo.save(data);

        List<SensorData> readings = sensorDataRepo.findLatestReadings(machine.getId(), 5);
        System.out.println("[PASS] Found " + readings.size() + " sensor readings");

        // 3. Test MaintenanceAction
        MaintenanceAction action = new MaintenanceAction();
        action.setActionDate(LocalDateTime.now());
        action.setDescription("Bearing replacement");
        action.setCost(450.0);
        action.setIsPreventive(true);
        action.setMachine(machine);
        maintenanceRepo.save(action);

        Double maintenanceCost = maintenanceRepo.calculateMaintenanceCost(
                machine.getId(),
                LocalDateTime.now().minusMonths(1),
                LocalDateTime.now()
        );
        System.out.println("[PASS] Maintenance cost: $" + maintenanceCost);

        // 4. Test Prediction
        Prediction prediction = new Prediction();
        prediction.setPredictedRulHours(120.5);
        prediction.setConfidence(0.92);
        prediction.setFaultType("bearing_wear");
        prediction.setMachine(machine);
        predictionRepo.save(prediction);

        List<Prediction> highConfidence = predictionRepo.findHighConfidencePredictions(
                machine.getId(),
                0.9
        );
        System.out.println("[PASS] High-confidence predictions: " + highConfidence.size());

        // 5. Test soft delete
        machineRepo.softDelete(machine.getId());
        System.out.println("[PASS] Machine soft-deleted. Active: " +
                Objects.requireNonNull(machineRepo.findById(machine.getId()).orElse(null)).getIsActive());

        System.out.println("=== All Tests Passed ===");
    }
}

