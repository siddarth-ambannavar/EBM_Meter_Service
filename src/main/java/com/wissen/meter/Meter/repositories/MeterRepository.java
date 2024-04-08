package com.wissen.meter.Meter.repositories;

import com.wissen.meter.Meter.models.Meter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeterRepository extends JpaRepository<Meter, Long> {
}
