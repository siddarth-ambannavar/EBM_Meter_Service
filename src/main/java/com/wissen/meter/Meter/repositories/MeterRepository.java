package com.wissen.meter.Meter.repositories;

import com.wissen.meter.Meter.models.Meter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MeterRepository extends JpaRepository<Meter, Long> {
    @Query("SELECT m.meterId from Meter m")
    List<Long> findAllMeterIds();

    List<Meter> findByCustomerId(Integer customerId);
}
