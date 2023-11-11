package com.cinerama.proyecto.service;

import com.cinerama.proyecto.models.entitys.EstadoPelicula;

import java.util.List;

public interface EstadoPeliculaService {
    public List<EstadoPelicula> findAll();
    public EstadoPelicula save(EstadoPelicula estado);
}
