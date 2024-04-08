package com.wissen.meter.Meter.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usage")
public class UsageController {
    @GetMapping("/")
    public ResponseEntity<String> welcome(){
        return new ResponseEntity<String>("Usage Service", HttpStatus.OK);
    }
}
