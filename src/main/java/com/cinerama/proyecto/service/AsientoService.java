package com.cinerama.proyecto.service;

import com.cinerama.proyecto.models.entitys.Asientos;

import java.util.List;

public interface AsientoService {
    public List<Asientos> findAll();
    public Asientos save(Asientos asientos);
    public List<Asientos> findById(Long id);
    public List<Asientos> findAsientos(String id);
}
