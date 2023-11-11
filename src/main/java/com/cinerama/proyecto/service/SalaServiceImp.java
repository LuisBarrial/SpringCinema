package com.cinerama.proyecto.service;

import com.cinerama.proyecto.models.dao.SalaDao;
import com.cinerama.proyecto.models.entitys.Sala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaServiceImp implements SalaService {
    @Autowired
    private SalaDao salaDao;

    @Override
    public List<Sala> findAll() {
        return salaDao.findAll();
    }

    @Override
    public Sala save(Sala sala) {
        return salaDao.save(sala);
    }

    @Override
    public Sala findById(Integer id) {
        return salaDao.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        salaDao.deleteById(id);
    }
}
