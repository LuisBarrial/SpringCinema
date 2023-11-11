package com.cinerama.proyecto.service;

import com.cinerama.proyecto.models.entitys.Sala;

import java.util.List;

public interface SalaService {
    public List<Sala> findAll();
    public Sala save(Sala sala);
    public Sala findById(Integer id);
    public void deleteById(Integer id);
}
