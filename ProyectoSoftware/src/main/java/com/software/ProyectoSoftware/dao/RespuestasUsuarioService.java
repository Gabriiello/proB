package com.software.ProyectoSoftware.dao;

import com.software.ProyectoSoftware.Models.RespuestaUsuarioDTO;
import com.software.ProyectoSoftware.Models.RespuestasUsuario;
import com.software.ProyectoSoftware.Models.RespuestasUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespuestasUsuarioService {
    @Autowired
    private RespuestasUsuarioRepository respuestasUsuarioRepository;

    public void guardarRespuestas(List<RespuestaUsuarioDTO> respuestas) {
        for (RespuestaUsuarioDTO dto : respuestas) {
            RespuestasUsuario respuestaUsuario = new RespuestasUsuario();
            respuestaUsuario.setUsuarioId(dto.getUsuarioId());
            respuestaUsuario.setPreguntaId(dto.getPreguntaId());
            respuestaUsuario.setRespuestaId(dto.getRespuestaId());
            respuestasUsuarioRepository.save(respuestaUsuario);
        }
    }
}
