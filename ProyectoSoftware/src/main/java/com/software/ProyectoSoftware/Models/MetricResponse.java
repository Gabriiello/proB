package com.software.ProyectoSoftware.Models;

public class MetricResponse {
    private String pregunta;
    private long correctas;

    public MetricResponse(String pregunta, long correctas) {
        this.pregunta = pregunta;
        this.correctas = correctas;
    }

    // Getters y Setters

    public String getPregunta() {
        return pregunta;
    }

    public long getCorrectas() {
        return correctas;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public void setCorrectas(long correctas) {
        this.correctas = correctas;
    }
}
