package com.shmalts.metricsconsumer.repository;

import com.shmalts.metricsconsumer.model.Metric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricRepository extends JpaRepository<Metric, Integer> {

    Metric findByName(String name);
}
