package com.enset.maintenance_backend;

import com.enset.maintenance_backend.entities.Machine;
import jakarta.transaction.Transactional;
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
    @Autowired
    private FailureRepository failureRepo;

    public static void main(String[] args) {
        SpringApplication.run(MaintenancePlatformBackendApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("\n=== Testing Repositories ===\n");

        // 1. Test MachineRepository
        System.out.println("--- Testing MachineRepository ---");
        Machine machine = new Machine();
        machine.setName("Industrial Press");
        machine.setSerialNumber("IP-2023-001");
        machine.setExpectedLifetimeHours(LocalDate.now().plusYears(10));
        machine = machineRepo.save(machine);
        System.out.println("Saved Machine: " + machine);

        // 2. Test SensorDataRepository
        System.out.println("\n--- Testing SensorDataRepository ---");
        SensorData data1 = new SensorData();
        data1.setVibrationX(0.5);
        data1.setVibrationY(0.3);
        data1.setSpeedSet(1200.0);
        data1.setLoadValue(75.0);
        data1.setMachine(machine);
        sensorDataRepo.save(data1);

        SensorData data2 = new SensorData();
        data2.setVibrationX(0.6);
        data2.setVibrationY(0.4);
        data2.setSpeedSet(1250.0);
        data2.setLoadValue(80.0);
        data2.setMachine(machine);
        sensorDataRepo.save(data2);

        List<SensorData> latestReadings = sensorDataRepo.findLatestReadings(machine.getId(), 1);
        System.out.println("Latest sensor reading: " + latestReadings.get(0));

        // 3. Test MaintenanceActionRepository
        System.out.println("\n--- Testing MaintenanceActionRepository ---");
        MaintenanceAction action = new MaintenanceAction();
        action.setDescription("Bearing replacement");
        action.setCost(450.0);
        action.setActionDate(LocalDateTime.now());
        action.setIsPreventive(true);
        action.setMachine(machine);
        maintenanceRepo.save(action);

        List<MaintenanceAction> preventiveActions = maintenanceRepo
                .findByIsPreventiveAndMachineId(true, machine.getId());
        System.out.println("Preventive actions: " + preventiveActions);

        // 4. Test PredictionRepository
        System.out.println("\n--- Testing PredictionRepository ---");
        Prediction prediction = new Prediction();
        prediction.setPredictedRulHours(850.0);
        prediction.setConfidence(0.92);
        prediction.setFaultType("Bearing wear");
        prediction.setMachine(machine);
        predictionRepo.save(prediction);

        List<Prediction> highConfidence = predictionRepo
                .findHighConfidencePredictions(machine.getId(), 0.9);
        System.out.println("High confidence predictions: " + highConfidence);

        Double avgRUL = predictionRepo.calculateAverageRUL(machine.getId());
        System.out.println("Average RUL: " + avgRUL);

        // 5. Test FailureRepository
        System.out.println("\n--- Testing FailureRepository ---");
        Failure failure = new Failure();
        failure.setDowntimeHours(8.5);
        failure.setFaultType("Motor burnout");
        failure.setMachine(machine);
        failureRepo.save(failure);

        // Test soft delete from BaseRepository
        System.out.println("\n--- Testing BaseRepository softDelete ---");
        machineRepo.softDelete(machine.getId());
        System.out.println("Machine active status after soft delete: " +
                machineRepo.findById(machine.getId()).get().getIsActive());

        System.out.println("\n=== Repository Testing Complete ===");
    }
}

