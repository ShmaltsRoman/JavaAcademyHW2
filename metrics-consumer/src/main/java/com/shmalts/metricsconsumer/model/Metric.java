package com.shmalts.metricsconsumer.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "metrics")
public class Metric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(name = "metric_value")
    private Integer value;
    private LocalDate lastChanged;

    public Metric(Integer id, String name, Integer value, LocalDate lastChanged) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.lastChanged = lastChanged;
    }

    public Metric() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Metric{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", lastChanged=" + lastChanged +
                '}';
    }
}
