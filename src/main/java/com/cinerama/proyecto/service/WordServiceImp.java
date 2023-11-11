package com.cinerama.proyecto.service;

import com.cinerama.proyecto.models.dao.WordDao;
import com.cinerama.proyecto.models.entitys.Asientos;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WordServiceImp implements WordService{
    @Autowired
    private WordDao wordDao;

    @Override
    public void createWord(String title, String imagePath, String fileName) throws IOException, InvalidFormatException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
        wordDao.createWord(title,imagePath,fileName);
    }

    @Override
    public void gaurdarInfoUsuario(Asientos asientos) {
        wordDao.gaurdarInfoUsuario(asientos);
    }
}
