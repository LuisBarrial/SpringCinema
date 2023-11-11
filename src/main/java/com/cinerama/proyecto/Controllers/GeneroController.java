package com.cinerama.proyecto.Controllers;

import com.cinerama.proyecto.models.entitys.Genero;
import com.cinerama.proyecto.service.GeneroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GeneroController {
    @Autowired
    private GeneroService generoService;

    @GetMapping("/admin/generos")
    public String listarCategorias(Model modelo){
        List<Genero> listaGeneros = generoService.findAll(Sort.by("titulo"));
        modelo.addAttribute("listaGeneros",listaGeneros);
        return "admin/listas/generos";
    }

    @GetMapping("/admin/generos/nuevo")
    public String mostrarFormularioDeNuevaGenero(Model modelo){
        modelo.addAttribute("genero", new Genero());
        return "admin/formularios/genero_formulario";
    }

    @PostMapping("/admin/generos/guardar")
    public String guardarGenero(Genero generoPelicula){
        generoService.save(generoPelicula);
        return "redirect:/admin/generos";
    }
}
