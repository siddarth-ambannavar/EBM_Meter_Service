package com.wissen.meter.Meter.repositories;

import com.wissen.meter.Meter.models.Usage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsageRepository extends JpaRepository<Usage, Integer> {
//    Optional<Usage> findByMeter(String meterId);
//    @Query("SELECT u from USAGE where u.meter_id = :meterId")
//    List<Usage> getByMeterId(@Param("meterId") long meterId);
//
//    @Query("SELECT SUM(u.units_used) FROM USAGE u WHERE u.meter_id = :meterId AND MONTH(u.generated_date) = :month AND YEAR(u.generated_date) = :year")
//    Double getTotalUnitsUsedByMeterIdAndMonthYear(Long meterId, int month, int year);

    @Query("SELECT u from Usage u where u.meter.meterId = :meterId")
    List<Usage> getByMeterId(@Param("meterId") long meterId);
    @Query("SELECT SUM(u.unitsUsed) FROM Usage u WHERE u.meter.meterId = :meterId AND MONTH(u.generatedDate) = :month AND YEAR(u.generatedDate) = :year")
    Optional<Double> getTotalUnitsUsedByMeterIdAndMonthYear(Long meterId, int month, int year);
    @Query("SELECT u FROM Usage u WHERE u.meter.meterId = :meterId AND MONTH(u.generatedDate) = :month AND YEAR(u.generatedDate) = :year")
    List<Usage> getUsageByMeterIdAndMonthYear(Long meterId, int month, int year);
}
