package com.shmalts.metricsconsumer.listener;

import com.shmalts.metricsconsumer.mapper.MetricMapper;
import com.shmalts.metricsconsumer.model.Metric;
import com.shmalts.metricsconsumer.service.MetricService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    private final MetricService metricService;
    private final MetricMapper metricMapper;

    public Listener(MetricService metricService, MetricMapper metricMapper) {
        this.metricService = metricService;
        this.metricMapper = metricMapper;
    }

    @KafkaListener(containerFactory = "fooKafkaListenerContainerFactory", topics = "topic1")
    public void consume(MetricDto metricDto) {
        Metric metric = metricMapper.toModel(metricDto);
        metricService.saveMetrics(metric);
    }

}
