package com.wissen.meter.Meter.controllers;

import com.wissen.meter.Meter.ResponseBodies.MeterListResponse;
import com.wissen.meter.Meter.customExceptions.CustomerNotFoundException;
import com.wissen.meter.Meter.customExceptions.MeterRecordAlreadyExistsException;
import com.wissen.meter.Meter.externalServices.CustomerService;
import com.wissen.meter.Meter.models.Meter;
import com.wissen.meter.Meter.services.MeterService;
import com.wissen.meter.Meter.services.UsageService;
import lombok.RequiredArgsConstructor;
import java.util.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/meters")
@Slf4j
@CrossOrigin({"http://localhost:4200"})
@RequiredArgsConstructor
public class MeterController {

    @Autowired
    private MeterService meterService;
    @Autowired
    private UsageService usageService;
    @Autowired
    private CustomerService customerService;

    @GetMapping("/get-all-meters")
    public ResponseEntity<List<Long>> getAllMeters(){
        List<Long> meters = meterService.getAllMeterIds();
        log.info("List of All Meters");
        return new ResponseEntity<>(meters, HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/new-meter/{meterNo}")
    public ResponseEntity<Meter> addMeterRecord(@RequestHeader("Authorization") String token, @PathVariable Long meterNo) {
        Integer customerId = customerService.getCustomerId(token);
        if (customerId == null)
            throw new CustomerNotFoundException("Customer Not Found");
        if (meterService.isMeterNumberExists(meterNo))
            throw new MeterRecordAlreadyExistsException("Meter Number: " + meterNo + " Already Registered");
        Meter newMeter = new Meter(meterNo, customerId);
        log.info("---- {} ----", meterNo);
        meterService.addMeter(newMeter);
        log.info("New Meter added, CustomerId: {}, MeterId: {}", newMeter.getCustomerId(), newMeter.getMeterId());
        return new ResponseEntity<>(newMeter, HttpStatus.OK);
    }

    @GetMapping("/get-user-meters")
    public ResponseEntity<MeterListResponse> getLoggedInUsersMeterNumbers(@RequestHeader("Authorization") String token) {
        Integer customerId = customerService.getCustomerId(token);
        if (customerId == null)
            throw new CustomerNotFoundException("Customer Not Found");
        List<Long> meters = meterService.findUserMeters(customerId);
        MeterListResponse response = MeterListResponse.builder()
                .message("List of Your Meters")
                .status(HttpStatus.OK)
                .meters(meters)
                .build();
        log.info("All meter of Customer with id: {}", customerId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/removecustmeters/{customerId}")
    public String removeCustomerMeters(@PathVariable int customerId) {
        List<Long> customerMeters = meterService.findUserMeters(customerId);
        for(Long meter : customerMeters)
            usageService.deleteUsagesByMeterId(meter);
        return meterService.deleteMetersByCustomerId(customerId);
    }
}
