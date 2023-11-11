package com.cinerama.proyecto.models.dao;

import com.cinerama.proyecto.models.entitys.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaDao extends JpaRepository<Sala, Integer> {
}
