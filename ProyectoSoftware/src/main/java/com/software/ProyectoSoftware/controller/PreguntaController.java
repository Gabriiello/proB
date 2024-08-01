package com.software.ProyectoSoftware.controller;

import com.software.ProyectoSoftware.Models.Pregunta;
import com.software.ProyectoSoftware.dao.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/preguntas")

public class PreguntaController {
    @Autowired
    private PreguntaService preguntaService;

    @GetMapping
    public List<Pregunta> getAllPreguntas() {
        return preguntaService.getAllPreguntas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pregunta> getPreguntaById(@PathVariable int id) {
        Optional<Pregunta> pregunta = preguntaService.getPreguntaById(id);
        return pregunta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pregunta> createPregunta(@RequestBody Pregunta pregunta) {
        if (pregunta.getCuestionario() == null) {
            return ResponseEntity.badRequest().build(); // Asegúrate de que el cuestionario esté presente
        }
        // Asegúrate de que el ID del cuestionario esté presente y válido
        Integer cuestionarioId = pregunta.getCuestionario().getId();
        if (cuestionarioId == null || cuestionarioId <= 0) {
            return ResponseEntity.badRequest().build();
        }
        Pregunta savedPregunta = preguntaService.savePregunta(pregunta);
        return ResponseEntity.ok(savedPregunta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pregunta> updatePregunta(@PathVariable int id, @RequestBody Pregunta pregunta) {
        if (!preguntaService.getPreguntaById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        pregunta.setId(id);
        Pregunta updatedPregunta = preguntaService.savePregunta(pregunta);
        return ResponseEntity.ok(updatedPregunta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePregunta(@PathVariable int id) {
        if (!preguntaService.getPreguntaById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        preguntaService.deletePregunta(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cuestionario/{cuestionarioId}")
    public List<Pregunta> getPreguntasByCuestionarioId(@PathVariable int cuestionarioId) {
        return preguntaService.getPreguntasByCuestionarioId(cuestionarioId);
    }
}
