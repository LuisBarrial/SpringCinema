package com.cinerama.proyecto.Controllers;

import com.cinerama.proyecto.models.entitys.Funcion;
import com.cinerama.proyecto.models.entitys.Pelicula;
import com.cinerama.proyecto.models.entitys.Sala;
import com.cinerama.proyecto.service.FuncionService;
import com.cinerama.proyecto.service.PeliculaService;
import com.cinerama.proyecto.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ComprarController {
    @Autowired
    private PeliculaService peliculaService;

    @Autowired
    private SalaService salaService;

    @Autowired
    private FuncionService funcionService;

    @GetMapping("/usuario/pelicula/{idpelicula}/sala/{idsala}/{horario}/comprar")
    public String comprarPelicula(@PathVariable("idpelicula") Integer idpelicula, Model modelo, @PathVariable("idsala") Integer idsala, @PathVariable("horario") String horario){
        Pelicula pelicula = peliculaService.findById(idpelicula);
        modelo.addAttribute("pelicula",pelicula);

        return "usuario/prueba";
    }

    @GetMapping("/usuario/pelicula/{id}/sala")
    public String salaPelicula(@PathVariable("id") Integer id,Model modelo){
        List<Sala> sala = salaService.findAll();
        List<Funcion> funciones = funcionService.findAll();
        List<Funcion> Horarios = new ArrayList<Funcion>();
        for (int i=0; i<funciones.size(); i++){
            if(funciones.get(i).getPelicula().getId() == id){
                Horarios.add(funciones.get(i));
            }
        }

        modelo.addAttribute("sala",sala);
        modelo.addAttribute("funciones",Horarios);

        return "usuario/salasUser";
    }

    @GetMapping("/usuario/pelicula/{idpelicula}/sala/{idsala}/{horario}/asiento")
    public String obtenerAsientosValor(Model modelo, @PathVariable("idpelicula") Integer id, @PathVariable("idsala") Integer idsala, @PathVariable("horario") String horario){
        Sala sala = salaService.findById(idsala);
        Pelicula pelicula = peliculaService.findById(id);
        modelo.addAttribute("pelicula",pelicula);


        return "usuario/Asientos";
    }

    @GetMapping("/usuario/pelicula/{idpelicula}/sala/{idsala}/{horario}/entrada")
    public String comprarEPelicula(@PathVariable("idpelicula") Integer id, Model modelo,@PathVariable("idsala") Integer idsala, @PathVariable("horario") String horario){


        Pelicula pelicula = peliculaService.findById(id);
        List<Funcion> listaFunciones = funcionService.findAll();
        modelo.addAttribute("listaFunciones",listaFunciones);
        modelo.addAttribute("pelicula",pelicula);

        return "usuario/entradas";
    }
}
