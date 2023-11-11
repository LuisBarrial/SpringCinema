package com.cinerama.proyecto.service;

import com.cinerama.proyecto.models.dao.EstadoCarteleraDao;
import com.cinerama.proyecto.models.entitys.EstadoCartelera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EstadoCarteleraServiceImp implements EstadoCarteleraService{
    @Autowired
    private EstadoCarteleraDao carteleraDao;

    @Override
    public List<EstadoCartelera> findAll() {
        return carteleraDao.findAll();
    }

    @Override
    public EstadoCartelera save(EstadoCartelera estado) {
        return carteleraDao.save(estado);
    }
}
