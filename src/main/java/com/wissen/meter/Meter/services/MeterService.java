package com.wissen.meter.Meter.services;

import com.wissen.meter.Meter.models.Meter;
import java.util.*;

public interface MeterService {

    // adding new meter
    Meter addMeter(Meter meter);
    boolean isMeterNumberExists(long meterNumber);

    List<Long> getAllMeterIds();
}
