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
    @Column(name = "CUSTOMER_ID")
    private Integer customerId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PHONE_NUMBER")
    private String phNo;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ADDRESS")
    private String address;

    public Customer() {
        // Default Constructor
    }

    public Customer(String name, String phNo, String password, String address) {
        this.name = name;
        this.phNo = phNo;
        this.password = password;
        this.address = address;
    }
}
