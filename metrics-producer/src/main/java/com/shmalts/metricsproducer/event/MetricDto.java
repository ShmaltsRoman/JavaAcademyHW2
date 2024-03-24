package com.shmalts.metricsproducer.event;


import java.time.LocalDate;

public class MetricDto {
    private String Name;
    private Integer value;
    private LocalDate lastChanged;

    public MetricDto(String name, Integer value, LocalDate lastChanged) {
        Name = name;
        this.value = value;
        this.lastChanged = lastChanged;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public LocalDate getLastChanged() {
        return lastChanged;
    }

    public void setLastChanged(LocalDate lastChanged) {
        this.lastChanged = lastChanged;
    }

    @Override
    public String toString() {
        return "MetricDto{" +
                "Name='" + Name + '\'' +
                ", value=" + value +
                ", lastChanged=" + lastChanged +
                '}';
    }
}
