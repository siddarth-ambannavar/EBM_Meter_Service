package com.wissen.meter.Meter.controllers;

import java.time.LocalDate;
import java.util.*;

import com.wissen.meter.Meter.models.Usage;
import com.wissen.meter.Meter.services.UsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usage")
@CrossOrigin({"http://localhost:4200"})
public class UsageController {
    @Autowired
    private UsageService usageService;

    @GetMapping
    public ResponseEntity<List<Usage>> getAllUsage(){
        return new ResponseEntity<>(usageService.retrieveAllUsageDetails(), HttpStatus.OK);
    }
    @GetMapping("/meter/{meterId}")
    public ResponseEntity<List<Usage>> getUsageByMeterId(@PathVariable long meterId){
        return new ResponseEntity<>(usageService.retrieveUsageByMeterId(meterId), HttpStatus.OK);
    }

    @GetMapping("/get-monthly")
    public ResponseEntity<Double> getTotalUsageByMonth(@RequestParam("meter_id") long meterId, @RequestParam("date") String date){
        if(usageService.retrieveUsageByMeterId(meterId).size() == 0){
            return new ResponseEntity<Double>(0.0, HttpStatus.NOT_FOUND);
        }
        LocalDate localDate = LocalDate.parse(date);
        return new ResponseEntity<Double>(usageService.getUnitsUsedInMonth(meterId, localDate), HttpStatus.OK);
    }



}
