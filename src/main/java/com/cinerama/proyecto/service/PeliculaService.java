package com.cinerama.proyecto.service;

import com.cinerama.proyecto.models.entitys.Pelicula;

import java.util.List;

public interface PeliculaService {
    public List<Pelicula> findAll();
    public Pelicula save(Pelicula pelicula);
    public Pelicula findById(Integer id);
    public void deleteById(Integer id);
}
