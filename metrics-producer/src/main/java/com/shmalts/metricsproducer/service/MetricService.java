package com.shmalts.metricsproducer.service;

import com.shmalts.metricsproducer.event.MetricDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MetricService {

    private final KafkaTemplate<String, MetricDto> kafkaTemplate;

    public MetricService(KafkaTemplate<String, MetricDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public boolean postMetrics(List<MetricDto> metricDtoList) {
        metricDtoList.stream()
                .map(metricDto -> {
                    metricDto.setLastChanged(LocalDate.now());
                    return metricDto;
                })
                .peek(System.out::println)
                .forEach(metricDto -> kafkaTemplate.send("topic1", metricDto));

        return true;
    }
}
