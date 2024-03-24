package com.shmalts.metricsconsumer.service;

import com.shmalts.metricsconsumer.model.Metric;
import com.shmalts.metricsconsumer.repository.MetricRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetricService {

    private final MetricRepository metricRepository;

    public MetricService(MetricRepository metricRepository) {
        this.metricRepository = metricRepository;
    }

    public void saveMetrics(Metric metric) {

        Metric existedMetric = metricRepository.findByName(metric.getName());

        if (existedMetric != null) {
            existedMetric.setName(metric.getName());
            existedMetric.setValue(metric.getValue());
            existedMetric.setLastChanged(metric.getLastChanged());
            metricRepository.save(existedMetric);
        } else {
            metricRepository.save(metric);
        }
    }

    public List<Metric> getAllMetrics() {
        return metricRepository.findAll();
    }

    public Metric getById(Integer Id) {
        return metricRepository.findById(Id).orElse(null);
    }
}
