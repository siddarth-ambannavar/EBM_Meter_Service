package com.wissen.meter.Meter.externalServices;

import com.wissen.meter.Meter.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "CUSTOMERSERVICE")
public interface CustomerService {

    @GetMapping("/customers/user")
    Customer getCustomer(@RequestHeader("Authorization") String token);
}
