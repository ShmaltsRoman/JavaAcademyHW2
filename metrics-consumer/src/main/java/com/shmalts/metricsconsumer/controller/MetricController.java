package com.shmalts.metricsconsumer.controller;

import com.shmalts.metricsconsumer.listener.MetricDto;
import com.shmalts.metricsconsumer.mapper.MetricMapper;
import com.shmalts.metricsconsumer.service.MetricService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MetricController {

    Logger logger = LoggerFactory.getLogger(MetricController.class);

    private final MetricMapper metricMapper;
    private final MetricService metricService;

    public MetricController(MetricMapper metricMapper, MetricService metricService) {
        this.metricMapper = metricMapper;
        this.metricService = metricService;
    }

    @RequestMapping(value = "/metrics",method = RequestMethod.GET)
    public List<MetricDto> getAllMetrics() {
        logger.info("Request (getAllMetrics)");
        List<MetricDto> response = metricService.getAllMetrics().stream()
                .map(metricMapper::toDto)
                .collect(Collectors.toList());
        logger.info("Response (getAllMetrics) : {}", response);

        return response;
    }

    @RequestMapping(value = "/metrics/{id}",method = RequestMethod.GET)
    public MetricDto getMetricById(@PathVariable Integer id) {
        logger.info("Request (getMetricById)");
        MetricDto response = metricMapper.toDto(metricService.getById(id));
        logger.info("Response (getAllMetrics) : {}", response);

        return response;
    }
}
