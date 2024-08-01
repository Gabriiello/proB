package com.software.ProyectoSoftware.dao;

import com.software.ProyectoSoftware.Models.MetricResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/metrics")
public class MetricasController {
    @Autowired
    private MetricasService metricaService;

    @GetMapping
    public List<MetricResponse> getMetrics() {
        return metricaService.getCorrectAnswersMetrics();
    }
}
