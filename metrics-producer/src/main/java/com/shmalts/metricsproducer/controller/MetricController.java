package com.shmalts.metricsproducer.controller;

import com.shmalts.metricsproducer.event.MetricDto;
import com.shmalts.metricsproducer.service.MetricService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MetricController {

    private final MetricService metricService;

    public MetricController(MetricService metricService) {
        this.metricService = metricService;
    }

    @RequestMapping(value = "/metrics",method = RequestMethod.POST)
    public boolean postMetrics(@RequestBody List<MetricDto> metrics) {
        return metricService.postMetrics(metrics);
    }
}
