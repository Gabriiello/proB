package com.software.ProyectoSoftware.dao;


import com.software.ProyectoSoftware.Models.Rol;
import com.software.ProyectoSoftware.Models.Usuario;
import com.software.ProyectoSoftware.Models.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void register(Usuario usuario) {
        usuario.setRol(Rol.USUARIO);
        usuario.setContraseña(passwordEncoder.encode(usuario.getContraseña()));

        usuarioRepository.save(usuario);
    }

    public Usuario authenticate(Usuario usuario) {
        Usuario existingUser = usuarioRepository.findByEmail(usuario.getEmail());
        if (existingUser != null && passwordEncoder.matches(usuario.getContraseña(), existingUser.getContraseña())) {
            return existingUser; // Devuelve el usuario autenticado con el rol
        }
        return null; // Devuelve null si la autenticación falla
    }
    // Método para encontrar usuario por correo electrónico
    public Usuario findByEmail(String email) {
        // Implementa la lógica para buscar el usuario en la base de datos
        return new Usuario(); // Cambia esto por la lógica real de búsqueda
    }
}
