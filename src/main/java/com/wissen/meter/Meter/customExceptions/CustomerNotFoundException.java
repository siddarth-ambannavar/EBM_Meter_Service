package com.wissen.meter.Meter.customExceptions;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException() {
        super("Customer Not found!");
    }

    public CustomerNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
