package com.wissen.meter.Meter.RequestBodies;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsageRequestBody {
    private String meterId;
    private Double unitsUsed;
}
