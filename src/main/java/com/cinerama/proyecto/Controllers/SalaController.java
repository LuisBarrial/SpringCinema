package com.cinerama.proyecto.Controllers;

import com.cinerama.proyecto.models.entitys.Sala;
import com.cinerama.proyecto.models.entitys.Sede;
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
public class SalaController {
    @Autowired
    private SalaService salaService;

    @Autowired
    private SedeService sedeService;

    @GetMapping("/admin/salas/nueva")
    public String mostrarFormularioDeNuevoSala(Model modelo){
        List<Sede> listaSedes = sedeService.findAll();
        modelo.addAttribute("sala", new Sala());
        modelo.addAttribute("listaSedes", listaSedes);
        return "admin/formularios/salas_formulario";
    }

    @PostMapping("admin/salas/guardar")
    public String guardarSala(Sala sala){
        salaService.save(sala);
        return "redirect:/admin/salas";
    }

    @GetMapping("/admin/salas")
    public String listarSalas(Model modelo){
        List<Sala> listaSalas = salaService.findAll();
        modelo.addAttribute("listaSalas",listaSalas);
        return "admin/listas/salas";
    }

    @GetMapping("/admin/salas/editar/{id}")
    public String mostrarFormularioDeModificarSalas(@PathVariable("id") Integer id, Model modelo){
        Sala sala = salaService.findById(id);
        modelo.addAttribute("sala", sala);

        List<Sede> listaSedes = sedeService.findAll();
        modelo.addAttribute("listaSedes", listaSedes);

        return "admin/formularios/salas_formulario";
    }

    @GetMapping("/admin/salas/eliminar/{id}")
    public String eliminarSala(@PathVariable("id") Integer id, Model modelo){
        salaService.deleteById(id);
        return "redirect:/salas";
    }
}
