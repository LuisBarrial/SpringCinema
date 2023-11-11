package com.cinerama.proyecto.models.dao;

import com.cinerama.proyecto.models.entitys.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroDao extends JpaRepository<Genero, Integer> {
}
