package com.wissen.meter.Meter.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "USAGE")
public class Usage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "USAGE_ID")
    private Integer usageId;
    @Column(name = "UNITS_USED", nullable = false)
    private Double unitsUsed;
    @Column(name = "GENERATED_DATE", nullable = false)
    private LocalDate generatedDate;
    @ManyToOne
    @JoinColumn(name = "METER_ID", nullable = false)
    private Meter meter;
}