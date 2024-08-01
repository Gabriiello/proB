package com.software.ProyectoSoftware.dao;

import com.software.ProyectoSoftware.Models.MetricResponse;
import com.software.ProyectoSoftware.Models.RespuestasUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetricasService {
    @Autowired
    private RespuestasUsuarioRepository respuestasUsuarioRepository;

    public List<MetricResponse> getCorrectAnswersMetrics() {
        return respuestasUsuarioRepository.getCorrectAnswersMetrics();
    }
}
