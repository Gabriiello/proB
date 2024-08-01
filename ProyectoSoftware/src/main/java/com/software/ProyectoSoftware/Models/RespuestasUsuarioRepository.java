package com.software.ProyectoSoftware.Models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespuestasUsuarioRepository extends JpaRepository<RespuestasUsuario, Integer> {
    @Query("SELECT new com.software.ProyectoSoftware.Models.MetricResponse(p.texto, COUNT(r.id)) " +
            "FROM RespuestasUsuario r " +
            "JOIN Pregunta p ON r.preguntaId = p.id " +
            "JOIN Respuesta res ON r.respuestaId = res.id " +
            "WHERE res.esCorrecta = true " +
            "GROUP BY p.texto")
    List<MetricResponse> getCorrectAnswersMetrics();
}
