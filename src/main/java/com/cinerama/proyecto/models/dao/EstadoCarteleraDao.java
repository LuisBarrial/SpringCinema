package com.cinerama.proyecto.models.dao;

import com.cinerama.proyecto.models.entitys.EstadoCartelera;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoCarteleraDao extends JpaRepository<EstadoCartelera, Integer> {
}
