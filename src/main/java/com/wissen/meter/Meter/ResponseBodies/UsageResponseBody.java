package com.wissen.meter.Meter.ResponseBodies;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsageResponseBody {
    private String meterId;
    private Double unitsUsed;
    private Date generatedDate;
}
