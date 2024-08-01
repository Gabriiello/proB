package com.software.ProyectoSoftware.dao;
import com.software.ProyectoSoftware.Models.Respuesta;
import com.software.ProyectoSoftware.Models.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespuestaService {
    @Autowired
    private RespuestaRepository respuestaRepository;

    public List<Respuesta> getAllRespuestas() {
        return respuestaRepository.findAll();
    }

    public List<Respuesta> getRespuestasByPreguntaId(Long preguntaId) {
        return respuestaRepository.findByPreguntaId(preguntaId);
    }

    public Optional<Respuesta> getRespuestaById(Long id) {
        return respuestaRepository.findById(id);
    }

    public Respuesta saveRespuesta(Respuesta respuesta) {
        return respuestaRepository.save(respuesta);
    }

    public void deleteRespuesta(Long id) {
        respuestaRepository.deleteById(id);
    }
}
