package com.wissen.meter.Meter.services;

import com.wissen.meter.Meter.models.Meter;

public interface MeterService {

    // adding new meter
    Meter addMeter(Meter meter);

    boolean isMeterNumberExists(long meterNumber);
}
