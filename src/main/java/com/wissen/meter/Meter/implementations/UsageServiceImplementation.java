package com.wissen.meter.Meter.implementations;

import com.wissen.meter.Meter.models.Usage;
import com.wissen.meter.Meter.repositories.UsageRepository;
import com.wissen.meter.Meter.services.UsageService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class UsageServiceImplementation implements UsageService {

    @Autowired
    private UsageRepository usageRepository;
    @Override
    public List<Usage> retrieveAllUsageDetails() {
        return usageRepository.findAll();
    }

//    @Override
//    public Usage retrieveUsageByMeterId(String meterId) {
//        return usageRepository.findByMeter(meterId).orElse(null);
//    }
}
