package com.wissen.meter.Meter.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Meter {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long meterId;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
