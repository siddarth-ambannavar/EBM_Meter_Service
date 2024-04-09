package com.wissen.meter.Meter.controllers;

import com.wissen.meter.Meter.externalServices.CustomerService;
import com.wissen.meter.Meter.models.Customer;
import com.wissen.meter.Meter.models.Meter;
import com.wissen.meter.Meter.services.MeterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meters")
@RequiredArgsConstructor
public class MeterController {

    @Autowired
    private MeterService meterService;
//    @Autowired
//    private CustomerService customerService;

    @PostMapping("/new-meter")
    public ResponseEntity<Meter> addMeterRecord(@RequestBody Meter meter) {
//        Customer customer = customerService.getCustomer(meter.getCustomerId());
//        if(customer == null)
//            return null;
//        if(meterService.isMeterNumberExists(meter.getMeterNumber()))
//            return null;
//        Meter newMeter = new Meter(meter.getMeterNumber(), customer);
//        meterService.addMeter(newMeter);
        return new ResponseEntity<>(meter, HttpStatus.OK);
    }
}
