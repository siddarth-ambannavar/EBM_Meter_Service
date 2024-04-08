package com.wissen.meter.Meter.services;

import com.wissen.meter.Meter.models.Usage;

import java.util.List;

public interface UsageService {
    List<Usage> retrieveAllUsageDetails();
    Usage retrieveUsageByMeterId(String meterId);

}
