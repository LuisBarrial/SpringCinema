package com.cinerama.proyecto.service;

import com.cinerama.proyecto.models.entitys.Clasificacion;

import java.util.List;

public interface ClasificacionService {
    public List<Clasificacion> findAll();
    public Clasificacion save(Clasificacion clasificacion);
}
