package com.wissen.meter.Meter.externalServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "CUSTOMERSERVICE")
public interface CustomerService {

    @GetMapping("/customers/get-id")
    Integer getCustomerId(@RequestHeader("Authorization") String authHeader);
}
