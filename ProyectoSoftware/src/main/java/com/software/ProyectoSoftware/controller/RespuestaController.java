package com.software.ProyectoSoftware.controller;
import com.software.ProyectoSoftware.Models.Respuesta;
import com.software.ProyectoSoftware.dao.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/respuestas")
public class RespuestaController {
    @Autowired
    private RespuestaService respuestaService;

    // Obtener todas las respuestas
    @GetMapping
    public List<Respuesta> getAllRespuestas() {
        return respuestaService.getAllRespuestas();
    }

    // Obtener respuestas por ID de pregunta
    @GetMapping("/pregunta/{preguntaId}")
    public List<Respuesta> getRespuestasByPreguntaId(@PathVariable Long preguntaId) {
        return respuestaService.getRespuestasByPreguntaId(preguntaId);
    }

    // Obtener respuesta por ID
    @GetMapping("/{id}")
    public Respuesta getRespuestaById(@PathVariable Long id) {
        return respuestaService.getRespuestaById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Respuesta not found for this id :: " + id));
    }

    // Crear nueva respuesta
    @PostMapping
    public ResponseEntity<Respuesta> createRespuesta(@RequestBody Respuesta respuesta) {
        //System.out.println("id"+respuesta.getPregunta().getId());
        // Asegúrate de que esCorrecta está siendo procesado
        System.out.println("Respuesta recibida: " + respuesta.getTexto() + ", esCorrecta: " + respuesta.EsCorrecta());
        Respuesta savedRespuesta = respuestaService.saveRespuesta(respuesta);
        return ResponseEntity.ok(savedRespuesta);

    }

    // Actualizar respuesta
    @PutMapping("/{id}")
    public Respuesta updateRespuesta(@PathVariable Long id, @RequestBody Respuesta respuestaDetails) {
        Respuesta respuesta = respuestaService.getRespuestaById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Respuesta not found for this id :: " + id));
        respuesta.setTexto(respuestaDetails.getTexto());
        respuesta.setEsCorrecta(respuestaDetails.EsCorrecta());
        return respuestaService.saveRespuesta(respuesta);
    }

    // Eliminar respuesta
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteRespuesta(@PathVariable Long id) {
        Respuesta respuesta = respuestaService.getRespuestaById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Respuesta not found for this id :: " + id));
        respuestaService.deleteRespuesta(id);
        return Map.of("deleted", true);
    }
}
