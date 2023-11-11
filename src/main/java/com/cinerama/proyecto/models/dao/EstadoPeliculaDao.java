package com.cinerama.proyecto.models.dao;

import com.cinerama.proyecto.models.entitys.EstadoPelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoPeliculaDao extends JpaRepository<EstadoPelicula,Integer> {
}
