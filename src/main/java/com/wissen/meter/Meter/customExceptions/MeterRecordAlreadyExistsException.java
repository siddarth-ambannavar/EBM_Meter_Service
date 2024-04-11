package com.wissen.meter.Meter.customExceptions;

public class MeterRecordAlreadyExistsException extends RuntimeException{

    public MeterRecordAlreadyExistsException() {
        super("Meter Number already registered");
    }

    public MeterRecordAlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }
}
