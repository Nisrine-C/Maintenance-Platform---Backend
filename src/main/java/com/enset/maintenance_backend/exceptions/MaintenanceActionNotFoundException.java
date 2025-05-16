package com.enset.maintenance_backend.exceptions;

public class MaintenanceActionNotFoundException extends RuntimeException {
    public MaintenanceActionNotFoundException(String message) {
        super(message);
    }
}
