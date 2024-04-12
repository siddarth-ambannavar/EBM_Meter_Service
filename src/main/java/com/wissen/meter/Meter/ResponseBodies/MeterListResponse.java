package com.wissen.meter.Meter.ResponseBodies;

import com.wissen.meter.Meter.models.Meter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeterListResponse {
    private String message;
    private final boolean success = true;
    private HttpStatus status;
    private List<Long> meters;
}
