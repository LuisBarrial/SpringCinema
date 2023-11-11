package com.cinerama.proyecto.service;

import com.cinerama.proyecto.models.dao.SedeDao;
import com.cinerama.proyecto.models.entitys.Sede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SedeServiceImp implements SedeService{
    @Autowired
    private SedeDao sedeDao;

    @Override
    public List<Sede> findAll() {
        return sedeDao.findAll();
    }

    @Override
    public Sede save(Sede sede) {
        return sedeDao.save(sede);
    }

    @Override
    public void deleteById(Integer id) {
        sedeDao.deleteById(id);
    }
}
