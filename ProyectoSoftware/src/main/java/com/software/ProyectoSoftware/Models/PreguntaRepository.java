package com.software.ProyectoSoftware.Models;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreguntaRepository extends JpaRepository<Pregunta, Integer>{
    List<Pregunta> findByCuestionarioId(int cuestionarioId);

}
