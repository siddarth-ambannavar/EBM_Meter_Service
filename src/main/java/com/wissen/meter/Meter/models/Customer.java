package com.wissen.meter.Meter.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", initialValue = 1, allocationSize = 1)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    private Integer customerId;
    private String name;
    private String phoneNumber;
    private String password;
    private String address;
}
