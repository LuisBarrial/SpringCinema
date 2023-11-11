package com.cinerama.proyecto.models.dao;

import com.cinerama.proyecto.models.entitys.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaDao extends JpaRepository<Pelicula, Integer> {
}
