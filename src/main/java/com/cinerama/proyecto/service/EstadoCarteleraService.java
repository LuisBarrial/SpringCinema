package com.cinerama.proyecto.service;

import com.cinerama.proyecto.models.entitys.EstadoCartelera;
import com.cinerama.proyecto.models.entitys.EstadoPelicula;

import java.util.List;

public interface EstadoCarteleraService {
    public List<EstadoCartelera> findAll();
    public EstadoCartelera save(EstadoCartelera estado);
}
