package com.shmalts.metricsconsumer.mapper;


import com.shmalts.metricsconsumer.listener.MetricDto;
import com.shmalts.metricsconsumer.model.Metric;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MetricMapper {
    Metric toModel(MetricDto metricDto);
    MetricDto toDto(Metric metric);
}
