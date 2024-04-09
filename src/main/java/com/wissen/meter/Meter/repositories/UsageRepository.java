package com.wissen.meter.Meter.repositories;

import com.wissen.meter.Meter.models.Usage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsageRepository extends JpaRepository<Usage, Integer> {
//    Optional<Usage> findByMeterId(String meterId);
}
