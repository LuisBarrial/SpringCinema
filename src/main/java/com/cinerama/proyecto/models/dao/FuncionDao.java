package com.cinerama.proyecto.models.dao;

import com.cinerama.proyecto.models.entitys.Funcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FuncionDao extends JpaRepository<Funcion,Integer> {
    @Query(value = "SELECT * FROM funcion u WHERE horario=?1 and sala_id " +
            "in (SELECT id FROM sala as r WHERE r.id = ?2)" +
            "and pelicula_id IN (SELECT id FROM pelicula as j WHERE j.id = ?3)" ,nativeQuery = true)
    Funcion findFuncionByHorarioAndSalaAndPelicula(String horario,String salaid,String peliculaid);
}
