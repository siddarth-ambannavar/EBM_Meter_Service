package com.wissen.meter.Meter.implementations;

import com.netflix.discovery.converters.Auto;
import com.wissen.meter.Meter.models.Meter;
import com.wissen.meter.Meter.models.Usage;
import com.wissen.meter.Meter.repositories.MeterRepository;
import com.wissen.meter.Meter.repositories.UsageRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Component
public class UsageGenerationTask {
    @Autowired
    private MeterRepository meterRepository;
    @Autowired
    private UsageRepository usageRepository;
    private static final Logger logger = LogManager.getLogger(UsageServiceImplementation.class);

    @Scheduled(cron = "* */2 * * * *")
    public void addUsageDaily() {
        logger.info("Job executed at "+new Date());
        List<Meter> meters = meterRepository.findAll();
        for(Meter meter: meters){
            double units = 1 + (Math.random()*30);
            Usage usage = Usage.builder()
                    .unitsUsed(units)
                    .generatedDate(LocalDate.now())
                    .build();
            usageRepository.save(usage);
        }
    }
}
