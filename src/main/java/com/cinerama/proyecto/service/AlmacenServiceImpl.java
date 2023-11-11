package com.cinerama.proyecto.service;

import com.cinerama.proyecto.excepciones.AlmacenException;
import com.cinerama.proyecto.excepciones.FileNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.*;

@Service
public class AlmacenServiceImpl implements AlmacenService{

    @Value("${storage.location}")
    private String storageLocation;

    //indicar que el metodo se va a ejecutar cada vez que se cree una nueva instancia de esta calse;
    @PostConstruct
    @Override
    public void iniciarAlmacenDeArchivos() {
        try {
            Files.createDirectories(Paths.get(storageLocation));
        }catch (IOException exception){
            throw new AlmacenException("Error al inicializar la ubicacion en el almacen de archivos");
        }

    }

    @Override
    public String alamcenarArchivo(MultipartFile archivo) {
        String nombreArchivo = archivo.getOriginalFilename();
        if (archivo.isEmpty()){
            throw new AlmacenException("No se puede almacenar un archivo vacio");

        }
        try {
            InputStream inputStream= archivo.getInputStream();
            Files.copy(inputStream,Paths.get(storageLocation).resolve(nombreArchivo), StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException exception){
            throw new AlmacenException("error al alamacenar el archivo " + nombreArchivo,exception);
        }
        return nombreArchivo;

    }

    @Override
    public Path cargarArchivo(String nombreArchivo) {
        return Paths.get(storageLocation).resolve(nombreArchivo);
    }

    @Override
    public Resource cargarComoRecurso(String nombreArchivo) {
        try {
            Path archivo = cargarArchivo(nombreArchivo);
            Resource recurso = new UrlResource(archivo.toUri());


            if (recurso.exists() || recurso.isReadable()){
                return recurso;
            }
            else {
                throw new FileNotFoundException("No se pudo encontrar el archivo "+nombreArchivo);
            }

        }catch (MalformedURLException | FileNotFoundException exception){
            throw new FileNotFoundException("No se pudo encontrar el archivo "+nombreArchivo);
        }
    }

    @Override
    public void eliminarArchivo(String nombreArchivo) {

        Path archivo = cargarArchivo(nombreArchivo);

        try {
            FileSystemUtils.deleteRecursively(archivo);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
