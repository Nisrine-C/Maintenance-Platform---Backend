package com.enset.maintenance_backend;

import com.enset.maintenance_backend.dtos.FailureDTO;
import com.enset.maintenance_backend.dtos.MaintenanceActionDTO;
import com.enset.maintenance_backend.dtos.SensorDataDTO;
import com.enset.maintenance_backend.entities.Machine;

import com.enset.maintenance_backend.services.MachineActionServiceImp;
import com.enset.maintenance_backend.services.SensorDataServiceImp;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.enset.maintenance_backend.repositories.*;
import com.enset.maintenance_backend.entities.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
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

    @Autowired
    private MachineActionServiceImp machineService ;
@Autowired
    private SensorDataServiceImp sensorDataService ;

    public static void main(String[] args) {
        SpringApplication.run(MaintenancePlatformBackendApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Machine machine = new Machine();
        machine.setName("Industrial Press");
        machine.setSerialNumber("IP-2023-001");
        machineRepo.save(machine);

        System.out.println("_________________________________");
        System.out.println(machine.getId());
        System.out.println(machine.getName());
        System.out.println(machine.getSerialNumber());
        System.out.println(machine.getCreatedAt());
        System.out.println(machine.getUpdatedAt());
        System.out.println(machine.getIsActive());
        System.out.println("_________________________________");

        Machine machine2 = new Machine();
        machine2.setName("Industrial Press");
        machine2.setSerialNumber("IP-2023-001");
        machineRepo.save(machine2);

        System.out.println("_________________________________");
        System.out.println(machine2.getId());
        System.out.println(machine2.getName());
        System.out.println(machine2.getSerialNumber());
        System.out.println(machine2.getCreatedAt());
        System.out.println(machine2.getUpdatedAt());
        System.out.println(machine2.getIsActive());
        System.out.println("_________________________________");

        Machine machine3 = new Machine();
        machine3.setName("Industrial Press");
        machine3.setSerialNumber("IP-2023-001");
        machineRepo.save(machine3);

        System.out.println("_________________________________");
        System.out.println(machine3.getId());
        System.out.println(machine3.getName());
        System.out.println(machine3.getSerialNumber());
        System.out.println(machine3.getCreatedAt());
        System.out.println(machine3.getUpdatedAt());
        System.out.println(machine3.getIsActive());
        System.out.println("____________________maintenance_____________");


        MaintenanceActionDTO dto = new MaintenanceActionDTO();
        dto.setActionDescription("test");
        dto.setCost(33.000f);
        dto.setMachineId(1L);
        dto.setActionDate(new Date());
        dto.setIsPreventive(false);
        machineService.create(dto);
        System.out.println("____________________sensor_____________");
        SensorDataDTO sensorDataDTO = new SensorDataDTO();
        sensorDataDTO.setMachineId(1L);
        sensorDataDTO.setVibrationX(2.2f);
        sensorDataDTO.setVibrationY(2.2f);
        sensorDataDTO.setSpeedSet(2.2f);
        sensorDataDTO.setMachineId(1L);
        sensorDataDTO.setLoadValue(null);
       sensorDataService.create(sensorDataDTO);



    }
}

