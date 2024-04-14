package com.wissen.meter.Meter.controllers;

import java.time.LocalDate;
import java.util.*;

import com.wissen.meter.Meter.ResponseBodies.UsageResponseBody;
import com.wissen.meter.Meter.models.Usage;
import com.wissen.meter.Meter.services.UsageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usage")
@Slf4j
@CrossOrigin({"http://localhost:4200"})
@RequiredArgsConstructor
public class UsageController {
    @Autowired
    private UsageService usageService;

    @GetMapping
    public ResponseEntity<List<Usage>> getAllUsage(){
        return new ResponseEntity<>(usageService.retrieveAllUsageDetails(), HttpStatus.OK);
    }
    @GetMapping("/meter/{meterId}")
    public ResponseEntity<List<Usage>> getUsageByMeterId(@PathVariable long meterId){
        log.info("All usages of Meter id: {}", meterId);
        return new ResponseEntity<>(usageService.retrieveUsageByMeterId(meterId), HttpStatus.OK);
    }

    @GetMapping("/get-monthly")
    public ResponseEntity<Double> getTotalUsageByMonth(@RequestParam("meter_id") long meterId, @RequestParam("date") String date){
        if(usageService.retrieveUsageByMeterId(meterId).isEmpty())
            return new ResponseEntity<Double>(0.0, HttpStatus.NOT_FOUND);
        LocalDate localDate = LocalDate.parse(date);
        log.info("Usage of Meter id: {} in {} month", meterId, localDate.getMonth());
        return new ResponseEntity<Double>(usageService.getUnitsUsedInMonth(meterId, localDate), HttpStatus.OK);
    }

    @GetMapping("/get-usage-monthly")
    public ResponseEntity<List<Usage>> getUsageByMonthYear(@RequestParam("meter_id") long meterId, @RequestParam("month") int month, @RequestParam("year") int year){
        log.info("Usage of Meter id: {} in {}/{}", meterId, month, year);
        return new ResponseEntity<List<Usage>>(usageService.getUsageByMonthYear(meterId, month, year), HttpStatus.OK);
    }
}
