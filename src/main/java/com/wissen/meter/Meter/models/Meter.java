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
    @Column(name = "METER_ID")
    private Long meterId;
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;
}
