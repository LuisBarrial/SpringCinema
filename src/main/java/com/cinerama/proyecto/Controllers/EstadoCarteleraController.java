package com.cinerama.proyecto.Controllers;

import com.cinerama.proyecto.models.entitys.EstadoCartelera;
import com.cinerama.proyecto.models.entitys.EstadoPelicula;
import com.cinerama.proyecto.models.entitys.Sede;
import com.cinerama.proyecto.service.EstadoCarteleraService;
import com.cinerama.proyecto.service.EstadoPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class EstadoCarteleraController {
    @Autowired
    private EstadoCarteleraService estadoCarteleraService;

    @GetMapping("/admin/estadosCartelera")
    public String listarEstados(Model modelo){
        List<EstadoCartelera> listaEstadosCartelera = estadoCarteleraService.findAll();
        modelo.addAttribute("listaEstadosCartelera", listaEstadosCartelera);
        return "admin/listas/estadosCartelera";
    }

    @GetMapping("/admin/estadosCartelera/nuevo")
    public String mostrarFormularioDeNuevoEstado(Model modelo){
        modelo.addAttribute("estadoC", new EstadoCartelera());
        return "admin/formularios/estadoCartelera_formulario";
    }

    @PostMapping("/admin/estadosCartelera/guardar")
    public String guardarEstado(EstadoCartelera estado){
        estadoCarteleraService.save(estado);
        return "redirect:/admin/estadosCartelera";
    }
}
