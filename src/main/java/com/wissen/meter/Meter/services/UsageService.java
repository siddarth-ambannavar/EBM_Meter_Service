package com.wissen.meter.Meter.services;

import com.wissen.meter.Meter.models.Usage;

import java.time.LocalDate;
import java.util.List;

public interface UsageService {
    List<Usage> retrieveAllUsageDetails();
//    Usage retrieveUsageByMeterId(String meterId);
    List<Usage> retrieveUsageByMeterId(long meterId);

    Double getUnitsUsedInMonth(long meterId, LocalDate date);
    List<Usage> getUsageByMonthYear(long meterId, int month, int year);

}
