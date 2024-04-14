package com.wissen.meter.Meter.implementations;

import com.wissen.meter.Meter.models.Usage;
import com.wissen.meter.Meter.repositories.UsageRepository;
import com.wissen.meter.Meter.services.UsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UsageServiceImplementation implements UsageService {

    @Autowired
    private UsageRepository usageRepository;
    @Override
    public List<Usage> retrieveAllUsageDetails() {
        return usageRepository.findAll();
    }

    @Override
    public List<Usage> retrieveUsageByMeterId(long meterId) {
        return usageRepository.getByMeterId(meterId);
    }

    @Override
    public Double getUnitsUsedInMonth(long meterId, LocalDate date) {
        int month = date.getMonthValue();
        int year = date.getYear();
        return usageRepository.getTotalUnitsUsedByMeterIdAndMonthYear(meterId, month, year).orElse(0.0);
    }

    @Override
    public List<Usage> getUsageByMonthYear(long meterId, int month, int year) {
        return usageRepository.getUsageByMeterIdAndMonthYear(meterId, month, year);
    }

    @Override
    public void deleteUsagesByMeterId(long meterId) {
        List<Usage> usages = usageRepository.getByMeterId(meterId);
        for(Usage u : usages)
            usageRepository.deleteById(u.getUsageId());
    }


//    @Override
//    public Usage retrieveUsageByMeterId(String meterId) {
//        return usageRepository.findByMeter(meterId).orElse(null);
//    }
}
