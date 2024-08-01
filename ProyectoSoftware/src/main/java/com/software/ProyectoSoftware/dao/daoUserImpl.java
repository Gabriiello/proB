package com.software.ProyectoSoftware.dao;

import com.software.ProyectoSoftware.Models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class daoUserImpl implements daoUser{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Usuario> getUsuarios() {
        TypedQuery<Usuario> query = entityManager.createQuery("SELECT u FROM proyectosoft2 u", Usuario.class);
        return query.getResultList();
    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public void agregar(Usuario NuevoUsuario) {
        entityManager.merge(NuevoUsuario);
    }

    @Override
    public Usuario iniciarSesion(Usuario usuario) {
        String query = "FROM user WHERE email = :email";

        // Create the query
        TypedQuery<Usuario> typedQuery = entityManager.createQuery(query, Usuario.class);

        // Set the parameter for the query
        typedQuery.setParameter("email", usuario.getEmail());

        // Execute the query and get the result list
        List<Usuario> usuarioCorrecto = typedQuery.getResultList();

        // Check if the user was found
        if (usuarioCorrecto.isEmpty()) {
            return null;
        }

        // Get the password from the database
        //String passwordBd = usuarioCorrecto.get(0).getPassword();

        // Perform password check (e.g., using Argon2)
        // Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2i);
        // if (!argon2.verify(passwordBd, usuario.getPassword())) {
        //     return null;
        // }

        // Return the found user
        return usuarioCorrecto.get(0);
    }
}
