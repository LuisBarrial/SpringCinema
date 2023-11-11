package com.cinerama.proyecto.Controllers;

import com.cinerama.proyecto.models.entitys.EstadoPelicula;
import com.cinerama.proyecto.models.entitys.Sede;
import com.cinerama.proyecto.service.EstadoPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EstadoPeliculaController {
    @Autowired
    private EstadoPeliculaService estadoService;

    @GetMapping("/admin/estadosPelicula")
    public String listarEstados(Model modelo){
        List<EstadoPelicula> listaEstados = estadoService.findAll();
        modelo.addAttribute("listaEstados", listaEstados);
        return "admin/listas/estadosPelicula";
    }

    @GetMapping("/admin/estadosPelicula/nuevo")
    public String mostrarFormularioDeNuevoEstado(Model modelo){
        modelo.addAttribute("estadoP", new EstadoPelicula());
        return "admin/formularios/estadoPelicula_formulario";
    }

    @PostMapping("/admin/estadosPelicula/guardar")
    public String guardarEstado(EstadoPelicula estado){
        estadoService.save(estado);
        return "redirect:/admin/estadosPelicula";
    }
}
