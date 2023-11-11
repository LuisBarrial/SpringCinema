package com.cinerama.proyecto.models.dao;

import com.cinerama.proyecto.models.entitys.Sede;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SedeDao extends JpaRepository<Sede,Integer> {
}
