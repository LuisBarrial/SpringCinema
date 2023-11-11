package com.cinerama.proyecto.service;

import com.cinerama.proyecto.models.dao.EstadoPeliculaDao;
import com.cinerama.proyecto.models.entitys.EstadoPelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoPeliculaServiceImp implements EstadoPeliculaService {
    @Autowired
    private EstadoPeliculaDao estadoDao;

    @Override
    public List<EstadoPelicula> findAll() {
        return estadoDao.findAll();
    }

    @Override
    public EstadoPelicula save(EstadoPelicula estado) {
        return estadoDao.save(estado);
    }
}
