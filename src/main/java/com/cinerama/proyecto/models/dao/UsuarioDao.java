package com.cinerama.proyecto.models.dao;

import com.cinerama.proyecto.models.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    public Usuario findByEmail(String email);
}
