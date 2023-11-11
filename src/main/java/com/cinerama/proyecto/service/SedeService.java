package com.cinerama.proyecto.service;

import com.cinerama.proyecto.models.entitys.Sede;

import java.util.List;

public interface SedeService {
    public List<Sede> findAll();
    public Sede save(Sede sede);
    public void deleteById(Integer id);
}
