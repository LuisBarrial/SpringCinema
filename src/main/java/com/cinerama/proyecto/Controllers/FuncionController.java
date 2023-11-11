package com.cinerama.proyecto.Controllers;

import com.cinerama.proyecto.models.entitys.Funcion;
import com.cinerama.proyecto.models.entitys.Pelicula;
import com.cinerama.proyecto.models.entitys.Sala;
import com.cinerama.proyecto.models.entitys.Sede;
import com.cinerama.proyecto.service.FuncionService;
import com.cinerama.proyecto.service.PeliculaService;
import com.cinerama.proyecto.service.SalaService;
import com.cinerama.proyecto.service.SedeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FuncionController {
    @Autowired
    private FuncionService funcionService;

    @Autowired
    private PeliculaService peliculaService;

    @Autowired
    private SedeService sedeService;

    @Autowired
    private SalaService salaService;

    @GetMapping("/admin/funciones/nuevo")
    public String mostrarFormularioDeNuevoFuncion(Model modelo){
        modelo.addAttribute("funcion", new Funcion());
        List<Pelicula> listaPeliculas = peliculaService.findAll();
        modelo.addAttribute("listaPeliculas", listaPeliculas);
        List<Sede> listaSedes = sedeService.findAll();
        modelo.addAttribute("listaSedes", listaSedes);
        List<Sala> listaSalas = salaService.findAll();

        modelo.addAttribute("listaSalas",listaSalas);
        return "admin/formularios/funcion_formulario";
    }

    @PostMapping("/admin/funciones/guardar")
    public String guardarFunciones(Funcion funcion){
        funcionService.save(funcion);
        return "redirect:/admin/funciones";
    }

    @GetMapping("/admin/funciones")
    public String listarFunciones(Model modelo){
        List<Funcion> listaFunciones = funcionService.findAll();
        modelo.addAttribute("listaFunciones",listaFunciones);
        return "admin/listas/funciones";
    }

    @GetMapping("/admin/funciones/editar/{id}")
    public String mostrarFormularioDeModificarFuncion(@PathVariable("id") Integer id, Model modelo){
        Funcion funcion = funcionService.findById(id);
        modelo.addAttribute("funcion", funcion);

        List<Pelicula> listaPeliculas = peliculaService.findAll();
        modelo.addAttribute("listaPeliculas", listaPeliculas);
        List<Sede> listaSedes = sedeService.findAll();
        modelo.addAttribute("listaSedes", listaSedes);
        List<Sala> listaSalas = salaService.findAll();
        modelo.addAttribute("listaSalas",listaSalas);

        return "admin/formularios/funcion_formulario";
    }

    @GetMapping("/admin/funciones/eliminar/{id}")
    public String eliminarFuncion(@PathVariable("id") Integer id, Model modelo){
        funcionService.deleteById(id);
        return "redirect:/admin";
    }
}
