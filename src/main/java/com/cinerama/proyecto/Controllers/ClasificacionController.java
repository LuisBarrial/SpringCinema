package com.cinerama.proyecto.Controllers;

import com.cinerama.proyecto.models.entitys.Clasificacion;
import com.cinerama.proyecto.service.ClasificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClasificacionController {
    @Autowired
    private ClasificacionService clasificacionService;

    @GetMapping("/admin/clasificacion")
    public String listarClasificaciones(Model modelo){
        List<Clasificacion> listaClasificaciones = clasificacionService.findAll();
        modelo.addAttribute("listaClasificaciones",listaClasificaciones);
        return "admin/listas/clasificacion";
    }

    @GetMapping("/admin/clasificacion/nuevo")
    public String mostrarFormularioDeNuevaClasificacion(Model modelo){
        modelo.addAttribute("clasificacion", new Clasificacion());
        return "admin/formularios/clasificacion_formulario";
    }

    @PostMapping("/admin/clasificacion/guardar")
    public String guardarClasificacion(Clasificacion clasificacion){
        clasificacionService.save(clasificacion);
        return "redirect:/admin/clasificacion";
    }
}
