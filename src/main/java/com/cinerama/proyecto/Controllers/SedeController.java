package com.cinerama.proyecto.Controllers;

import com.cinerama.proyecto.models.entitys.Sede;
import com.cinerama.proyecto.service.SedeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SedeController {

    @Autowired
    private SedeService sedeService;

    @GetMapping("/admin/sedes")
    public String listarSedes(Model modelo){
        List<Sede> listaSedes = sedeService.findAll();
        modelo.addAttribute("listaSedes", listaSedes);
        return "admin/listas/sedes";
    }

    @GetMapping("/admin/sedes/nuevo")
    public String mostrarFormularioDeNuevoSede(Model modelo){
        modelo.addAttribute("sede", new Sede());
        return "admin/formularios/sedes_formulario";
    }

    @PostMapping("/admin/sedes/guardar")
    public String guardarSede(Sede sede){
        sedeService.save(sede);
        return "redirect:/admin/sedes";
    }

    @GetMapping("/admin/sedes/eliminar/{id}")
    public String eliminarSede(@PathVariable("id") Integer id, Model modelo){
        sedeService.deleteById(id);
        return "redirect:/admin/sedes";
    }
}
