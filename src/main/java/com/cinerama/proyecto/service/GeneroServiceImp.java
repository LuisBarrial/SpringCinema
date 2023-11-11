package com.cinerama.proyecto.service;

import com.cinerama.proyecto.models.dao.GeneroDao;
import com.cinerama.proyecto.models.entitys.Genero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroServiceImp implements GeneroService{
    @Autowired
    private GeneroDao generoDao;

    @Override
    public List<Genero> findAll(Sort titulo) {
        return generoDao.findAll();
    }

    @Override
    public Genero save(Genero genero) {
        return generoDao.save(genero);
    }
}
