package com.wissen.meter.Meter.implementations;

import com.wissen.meter.Meter.models.Meter;
import com.wissen.meter.Meter.repositories.MeterRepository;
import com.wissen.meter.Meter.services.MeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MeterServiceImplementation implements MeterService {

    @Autowired
    private MeterRepository meterRepository;

    @Override
    public Meter addMeter(Meter meter) {
        return meterRepository.save(meter);
    }

    @Override
    public boolean isMeterNumberExists(long meterNumber) {
        return meterRepository.existsById(meterNumber);
    }

    @Override
    public List<Long> getAllMeterIds() {
       return meterRepository.findAllMeterIds();
    }

    @Override
    public List<Long> findUserMeters(Integer customerId) {
        List<Meter> meters = meterRepository.findByCustomerId(customerId);
        List<Long> meterNumbers = new ArrayList<>();
        for(Meter meter : meters)
            meterNumbers.add(meter.getMeterId());
        return meterNumbers;
    }

    @Override
    public String deleteMetersByCustomerId(Integer customerId) {
        List<Meter> customerMeters = meterRepository.findByCustomerId(customerId);
        for(Meter m : customerMeters)
            meterRepository.delete(m);
        return "All meters of Customer Removed";
    }

}
