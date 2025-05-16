package com.enset.maintenance_backend.exceptions;

public class FailureNotFoundException extends RuntimeException {
    public FailureNotFoundException(String message) {
        super(message);
    }
}
