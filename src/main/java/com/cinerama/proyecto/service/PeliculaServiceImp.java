package com.cinerama.proyecto.service;

import com.cinerama.proyecto.models.dao.PeliculaDao;
import com.cinerama.proyecto.models.entitys.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaServiceImp implements PeliculaService{
    @Autowired
    private PeliculaDao peliculaDao;

    @Override
    public List<Pelicula> findAll() {
        return peliculaDao.findAll();
    }

    @Override
    public Pelicula save(Pelicula pelicula) {
        return peliculaDao.save(pelicula);
    }

    @Override
    public Pelicula findById(Integer id) {
        return peliculaDao.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        peliculaDao.deleteById(id);
    }
}
