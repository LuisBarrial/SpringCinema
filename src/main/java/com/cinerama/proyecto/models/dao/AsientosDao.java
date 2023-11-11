package com.cinerama.proyecto.models.dao;


import com.cinerama.proyecto.models.entitys.Asientos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AsientosDao extends JpaRepository<Asientos,Long> {
    @Query(value = "SELECT * FROM asientos u WHERE funcion_id " +
            "in (SELECT j.id FROM funcion j WHERE j.id = ?1)" ,nativeQuery = true)
    List<Asientos> findAsientos(String id);
}


