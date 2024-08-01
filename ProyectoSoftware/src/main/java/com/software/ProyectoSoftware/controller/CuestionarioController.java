package com.software.ProyectoSoftware.controller;

import com.software.ProyectoSoftware.Models.Cuestionario;
import com.software.ProyectoSoftware.Models.CuestionarioRepository;
import com.software.ProyectoSoftware.dao.CuestionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api/cuestionarios")
public class CuestionarioController {
    @Autowired
    private CuestionarioRepository cuestionarioRepository;

    @GetMapping
    public List<Cuestionario> getAllCuestionarios() {
        return cuestionarioRepository.findAll();
    }

    @PostMapping
    public Cuestionario createCuestionario(@RequestBody Cuestionario cuestionario) {
        return cuestionarioRepository.save(cuestionario);
    }

    @PutMapping("/{id}")
    public Cuestionario updateCuestionario(@PathVariable int id, @RequestBody Cuestionario cuestionarioDetails) {
        Cuestionario cuestionario = cuestionarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cuestionario not found for this id :: " + id));
        cuestionario.setTitulo(cuestionarioDetails.getTitulo());
        cuestionario.setDescripcion(cuestionarioDetails.getDescripcion());
        return cuestionarioRepository.save(cuestionario);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteCuestionario(@PathVariable int id) {
        Cuestionario cuestionario = cuestionarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cuestionario not found for this id :: " + id));
        cuestionarioRepository.delete(cuestionario);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/{id}")
    public Cuestionario getCuestionarioById(@PathVariable int id) {
        return cuestionarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cuestionario not found for this id :: " + id));
    }
}
