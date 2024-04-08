package com.wissen.meter.Meter.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class Meter {
    @Id
    private Long meterNumber;
    @Transient
    private int customerId;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Meter() {
        // Default Constructor
    }

    public Meter(Long meterNumber, int customerId) {
        this.meterNumber = meterNumber;
        this.customerId = customerId;
    }

    public Meter(Long meterNumber, Customer customer) {
        this.meterNumber = meterNumber;
        this.customer = customer;
    }
}
