package com.cinerama.proyecto.service;


import com.cinerama.proyecto.models.dao.AsientosDao;
import com.cinerama.proyecto.models.entitys.Asientos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsientoServiceImp implements AsientoService {
    @Autowired
    private AsientosDao asientosDao;

    @Override
    public List<Asientos> findAll() {
        return asientosDao.findAll();
    }

    @Override
    public Asientos save(Asientos asientos) {
        return asientosDao.save(asientos);
    }

    @Override
    public List<Asientos> findById(Long id) {
        return (List<Asientos>) asientosDao.findById(id).orElse(null);
    }

    @Override
    public List<Asientos> findAsientos(String id) {
        return asientosDao.findAsientos(id);
    }
}
