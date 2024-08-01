package com.software.ProyectoSoftware.dao;


import com.software.ProyectoSoftware.Models.Cuestionario;
import com.software.ProyectoSoftware.Models.CuestionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuestionarioService {

    @Autowired
    private CuestionarioRepository cuestionarioRepository;

    public List<Cuestionario> getAllCuestionarios() {
        return cuestionarioRepository.findAll();
    }

    public Optional<Cuestionario> getCuestionarioById(int id) {
        return cuestionarioRepository.findById(id);
    }

    public Cuestionario saveCuestionario(Cuestionario cuestionario) {
        return cuestionarioRepository.save(cuestionario);
    }

    public void deleteCuestionario(int id) {
        cuestionarioRepository.deleteById(id);
    }
}
