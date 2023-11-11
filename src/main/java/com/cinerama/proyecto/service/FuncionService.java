package com.cinerama.proyecto.service;

import com.cinerama.proyecto.models.entitys.Funcion;

import java.util.List;

public interface FuncionService {
    public List<Funcion> findAll();
    public Funcion save(Funcion funcion);
    public Funcion findById(Integer id);
    public Funcion findFuncionByHorarioAndSalaAndPelicula(String horario,String salaid,String peliculaid);
    public void deleteById(Integer id);
}
