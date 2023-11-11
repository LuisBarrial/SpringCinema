package com.cinerama.proyecto.models.dao;

import com.cinerama.proyecto.models.entitys.Clasificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClasificacionDao extends JpaRepository<Clasificacion, Integer> {
}
