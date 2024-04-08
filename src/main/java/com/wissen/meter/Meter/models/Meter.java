package com.wissen.meter.Meter.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "METER")
public class Meter {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "METER_ID")
    private Long meterID;
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;
}
