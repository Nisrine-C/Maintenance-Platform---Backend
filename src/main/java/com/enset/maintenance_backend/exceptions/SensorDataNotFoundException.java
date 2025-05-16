package com.enset.maintenance_backend.exceptions;

public class SensorDataNotFoundException extends RuntimeException {
    public SensorDataNotFoundException(String message) {
        super(message);
    }
}
