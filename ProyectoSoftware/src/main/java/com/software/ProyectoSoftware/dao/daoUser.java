package com.software.ProyectoSoftware.dao;

import com.software.ProyectoSoftware.Models.Usuario;

import java.util.List;

public interface daoUser {
    List<Usuario> getUsuarios();

    void eliminar(int id);

    void agregar(Usuario NuevoUsuario);

    Usuario iniciarSesion(Usuario usuario);
}
