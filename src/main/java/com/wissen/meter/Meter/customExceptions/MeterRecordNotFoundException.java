package com.wissen.meter.Meter.customExceptions;

public class MeterRecordNotFoundException extends RuntimeException{

    public MeterRecordNotFoundException() {
        super("No Meter exists with this id");
    }

    public MeterRecordNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
