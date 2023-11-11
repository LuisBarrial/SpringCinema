package com.cinerama.proyecto.service;

import com.cinerama.proyecto.models.entitys.Genero;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface GeneroService {
    public List<Genero> findAll(Sort titulo);
    public Genero save(Genero genero);
}
