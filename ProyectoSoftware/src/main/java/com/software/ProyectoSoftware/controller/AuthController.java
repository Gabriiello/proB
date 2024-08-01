package com.software.ProyectoSoftware.controller;

import com.software.ProyectoSoftware.Models.Rol;
import com.software.ProyectoSoftware.Models.Usuario;
import com.software.ProyectoSoftware.dao.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController

@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Usuario usuario) {
        usuarioService.register(usuario);
        return ResponseEntity.ok("Usuario registrado exitosamente");
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Usuario usuario) {
        Usuario authenticatedUser = usuarioService.authenticate(usuario);

        Map<String, Object> response = new HashMap<>();

        if (authenticatedUser != null) {
            Rol rol = authenticatedUser.getRol();

            if (rol != null) {
                response.put("message", rol == Rol.ADMIN ? "Inicio de sesión exitoso como ADMIN" : "Inicio de sesión exitoso como USUARIO");
                response.put("rol", rol.name()); // Incluye el rol en la respuesta
                return ResponseEntity.ok(response);
            } else {
                response.put("message", "Rol del usuario es null");
                return ResponseEntity.status(500).body(response);
            }
        } else {
            response.put("message", "Credenciales inválidas");
            return ResponseEntity.status(401).body(response);
        }

    }

    // Clase para encapsular la respuesta del login
    public static class LoginResponse {
        private String rol;

        public LoginResponse(String rol) {
            this.rol = rol;
        }

        public String getRol() {
            return rol;
        }

        public void setRol(String rol) {
            this.rol = rol;
        }
    }
}
