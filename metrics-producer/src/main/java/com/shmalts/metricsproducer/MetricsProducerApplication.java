package com.shmalts.metricsproducer;

import com.shmalts.metricsproducer.event.MetricDto;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.LocalDate;

@SpringBootApplication
@AllArgsConstructor
public class MetricsProducerApplication {
    private final KafkaTemplate<String, MetricDto> kafkaTemplate;

    public static void main(String[] args) {
        SpringApplication.run(MetricsProducerApplication.class, args);
    }
}
