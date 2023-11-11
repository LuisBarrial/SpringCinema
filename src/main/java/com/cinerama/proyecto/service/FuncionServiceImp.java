package com.cinerama.proyecto.service;

import com.cinerama.proyecto.models.dao.FuncionDao;
import com.cinerama.proyecto.models.entitys.Funcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FuncionServiceImp implements FuncionService{
    @Autowired
    private FuncionDao funcionDao;

    @Override
    public List<Funcion> findAll() {
        return funcionDao.findAll();
    }

    @Override
    public Funcion save(Funcion funcion) {
        return funcionDao.save(funcion);
    }

    @Override
    public Funcion findById(Integer id) {
        return funcionDao.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        funcionDao.deleteById(id);
    }

    @Override
    public Funcion findFuncionByHorarioAndSalaAndPelicula(String horario, String salaid, String peliculaid) {
        return funcionDao.findFuncionByHorarioAndSalaAndPelicula(horario,salaid,peliculaid);
    }
}
