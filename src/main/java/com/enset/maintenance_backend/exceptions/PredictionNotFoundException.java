package com.enset.maintenance_backend.exceptions;

public class PredictionNotFoundException extends RuntimeException {
    public PredictionNotFoundException(String message) {
        super(message);
    }
}
