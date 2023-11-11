package com.cinerama.proyecto.service;

import com.cinerama.proyecto.models.entitys.Asientos;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public interface WordService {
    public void createWord(String title, String imagePath, String fileName) throws IOException, InvalidFormatException, org.apache.poi.openxml4j.exceptions.InvalidFormatException;
    public void gaurdarInfoUsuario(Asientos asientos);
}
