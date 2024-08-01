package com.software.ProyectoSoftware.controller;

import com.software.ProyectoSoftware.Models.RespuestaUsuarioDTO;
import com.software.ProyectoSoftware.dao.RespuestasUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/respuestasU")
public class RespuestasUsuarioController {
    @Autowired
    private RespuestasUsuarioService respuestasUsuarioService;

    @PostMapping
    public void guardarRespuestas(@RequestBody List<RespuestaUsuarioDTO> respuestas) {
        respuestasUsuarioService.guardarRespuestas(respuestas);
    }
}
