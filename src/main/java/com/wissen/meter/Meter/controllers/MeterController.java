package com.wissen.meter.Meter.controllers;

import com.wissen.meter.Meter.externalServices.CustomerService;
import com.wissen.meter.Meter.models.Customer;
import com.wissen.meter.Meter.models.Meter;
import com.wissen.meter.Meter.services.MeterService;
import lombok.RequiredArgsConstructor;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/meters")
@RequiredArgsConstructor
public class MeterController {

    @Autowired
    private MeterService meterService;
    @Autowired
    private CustomerService customerService;

    @GetMapping("/m/{token}")
    public Customer custom(@PathVariable String token) {
        String authorizationToken = "Bearer " + token;
        return customerService.getCustomer(authorizationToken);
    }

    @GetMapping
    public ResponseEntity<List<Long>> getAllMeters(){
        List<Long> meters = meterService.getAllMeterIds();
        if(meters.size() == 0){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(meters, HttpStatus.OK);
    }

    @PostMapping("/new-meter/{meterNo}")
    public ResponseEntity<Meter> addMeterRecord(@RequestHeader("Authorization") String token, @PathVariable Long meterNo) {
        Customer customer = customerService.getCustomer(token);
        if (customer == null)
            return null;
        if (meterService.isMeterNumberExists(meterNo))
            return null;
        Meter newMeter = new Meter(meterNo, customer);
        System.out.println("\n" + customer.getCustomerId() + "\n");
        meterService.addMeter(newMeter);
        return new ResponseEntity<>(newMeter, HttpStatus.OK);
    }
}
