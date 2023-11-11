package com.cinerama.proyecto.service;

import com.cinerama.proyecto.models.dao.ClasificacionDao;
import com.cinerama.proyecto.models.entitys.Clasificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasificacionServiceImp implements ClasificacionService{
    @Autowired
    private ClasificacionDao clasificacionDao;

    @Override
    public List<Clasificacion> findAll() {
        return clasificacionDao.findAll();
    }

    @Override
    public Clasificacion save(Clasificacion clasificacion) {
        return clasificacionDao.save(clasificacion);
    }
}
