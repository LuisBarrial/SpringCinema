package com.cinerama.proyecto.Controllers;

import com.cinerama.proyecto.models.entitys.*;
import com.cinerama.proyecto.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;

    @Autowired
    private GeneroService generoService;

    @Autowired
    private ClasificacionService clasificacionService;

    @Autowired
    private EstadoPeliculaService estadoService;

    @Autowired
    private AlmacenService almacenService;

    @Autowired
    private SedeService sedeService;

    @Autowired
    private EstadoCarteleraService estadoCarteleraService;

    @GetMapping("/admin/peliculas/nuevo")
    public String mostrarFormularioDeNuevoPelicula(Model modelo){
        modelo.addAttribute("pelicula", new Pelicula());
        List<Clasificacion> listaClasificaciones = clasificacionService.findAll();
        modelo.addAttribute("listaClasificaciones", listaClasificaciones);
        List<Genero> listaGeneros = generoService.findAll(Sort.by("titulo"));
        modelo.addAttribute("listaGeneros",listaGeneros);
        List<EstadoPelicula> listaEstados = estadoService.findAll();
        modelo.addAttribute("listaEstados",listaEstados);
        List<Sede> listaSedes = sedeService.findAll();
        modelo.addAttribute("listaSedes", listaSedes);
        List<EstadoCartelera> listaEstadosCartelera = estadoCarteleraService.findAll();
        modelo.addAttribute("listaEstadosCartelera",listaEstadosCartelera);
        return "admin/formularios/pelicula_formulario";
    }

    @PostMapping("/admin/peliculas/guardar")
    public String guardarPeliculas(@Validated Pelicula pelicula, HttpServletRequest request, BindingResult bindingResult, Model modelo){
        String[] detallesIDs = request.getParameterValues("detalleID");
        String[] detallesSinopsis = request.getParameterValues("detallesSinopsis");
        String[] detallesDirectores = request.getParameterValues("detallesDirector");
        String[] detallesRepartos = request.getParameterValues("detallesReparto");

        for (int i = 0; i < detallesSinopsis.length; i++){
            if (detallesIDs != null && detallesIDs.length > 0){
                pelicula.setDetalle(Integer.valueOf(detallesIDs[i]),detallesSinopsis[i],detallesDirectores[i],detallesRepartos[i]);
            } else{
                pelicula.añadirDetalles(detallesSinopsis[i],detallesDirectores[i],detallesRepartos[i]);
            }
        }

        if(bindingResult.hasErrors() || pelicula.getPortada().isEmpty()){
            if (pelicula.getPortada().isEmpty()) {
                bindingResult.rejectValue("portada", "MultipartNotEmpty");
            }
            List<Genero> generos = generoService.findAll(Sort.by("titulo"));
            modelo.addAttribute("pelicula",pelicula);
            modelo.addAttribute("generos",generos);
        }
        String rutaPortada = almacenService.alamcenarArchivo(pelicula.getPortada());
        pelicula.setRutaPortada(rutaPortada);

        peliculaService.save(pelicula);
        return "redirect:/admin/peliculas";
    }

    @GetMapping("/admin/peliculas")
    public String listarPeliculas(Model modelo){
        List<Pelicula> listaPeliculas = peliculaService.findAll();
        modelo.addAttribute("listaPeliculas",listaPeliculas);
        return "admin/listas/peliculas";
    }

    @GetMapping("/admin/peliculas/editar/{id}")
    public String mostrarFormularioDeModificarPelicula(@PathVariable("id") Integer id, Model modelo){
        Pelicula pelicula = peliculaService.findById(id);
        modelo.addAttribute("pelicula", pelicula);

        List<Genero> listaGeneros = generoService.findAll(Sort.by("titulo"));
        modelo.addAttribute("listaGeneros",listaGeneros);

        List<Clasificacion> listaClasificaciones = clasificacionService.findAll();
        modelo.addAttribute("listaClasificaciones", listaClasificaciones);

        List<EstadoPelicula> listaEstados = estadoService.findAll();
        modelo.addAttribute("listaEstados",listaEstados);

        List<Sede> listaSedes = sedeService.findAll();
        modelo.addAttribute("listaSedes", listaSedes);

        List<EstadoCartelera> listaEstadosCartelera = estadoCarteleraService.findAll();
        modelo.addAttribute("listaEstadosCartelera",listaEstadosCartelera);

        if (pelicula.getPortada()!=null){
            almacenService.eliminarArchivo(pelicula.getRutaPortada());
            String rutaPortada = almacenService.alamcenarArchivo(pelicula.getPortada());
            pelicula.setRutaPortada(rutaPortada);
        }

        return "admin/formularios/pelicula_formulario";
    }

    @GetMapping("/admin/peliculas/eliminar/{id}")
    public String eliminarPelicula(@PathVariable("id") Integer id, Model modelo){
        peliculaService.deleteById(id);
        //Pelicula pelicula = peliculaService.findById(id);
        //almacenService.eliminarArchivo(pelicula.getRutaPortada());
        return "redirect:/admin";
    }

    @GetMapping("/admin/peliculas/detalles/{id}")
    public String detallesPeliculaAdmin(@PathVariable("id") Integer id, Model modelo){
        Pelicula pelicula = peliculaService.findById(id);
        modelo.addAttribute("pelicula", pelicula);

        List<Genero> listaGeneros = generoService.findAll(Sort.by("titulo"));
        modelo.addAttribute("listaGeneros",listaGeneros);

        List<Clasificacion> listaClasificaciones = clasificacionService.findAll();
        modelo.addAttribute("listaClasificaciones", listaClasificaciones);

        List<EstadoPelicula> listaEstados = estadoService.findAll();
        modelo.addAttribute("listaEstados",listaEstados);

        List<EstadoCartelera> listaEstadosCartelera = estadoCarteleraService.findAll();
        modelo.addAttribute("listaEstadosCartelera",listaEstadosCartelera);

        return "usuario/detalle";
    }

    @GetMapping("/usuario/peliculas/detalles/{id}")
    public String detallesPeliculaUser(@PathVariable("id") Integer id, Model modelo){
        Pelicula pelicula = peliculaService.findById(id);
        modelo.addAttribute("pelicula", pelicula);

        List<Genero> listaGeneros = generoService.findAll(Sort.by("titulo"));
        modelo.addAttribute("listaGeneros",listaGeneros);

        List<Clasificacion> listaClasificaciones = clasificacionService.findAll();
        modelo.addAttribute("listaClasificaciones", listaClasificaciones);

        List<EstadoPelicula> listaEstados = estadoService.findAll();
        modelo.addAttribute("listaEstados",listaEstados);

        List<EstadoCartelera> listaEstadosCartelera = estadoCarteleraService.findAll();
        modelo.addAttribute("listaEstadosCartelera",listaEstadosCartelera);
        if(pelicula.getDetalles().isEmpty()){return "indexUsuario";}
        return "usuario/detalle";


    }

    @GetMapping("/")
    public String listarPeliculasEnIndex(Model modelo){
        List<Pelicula> listaPeliculas = peliculaService.findAll();
        modelo.addAttribute("listaPeliculas",listaPeliculas);

        List<Genero> listaGeneros = generoService.findAll(Sort.by("titulo"));
        modelo.addAttribute("listaGeneros",listaGeneros);

        List<Clasificacion> listaClasificaciones = clasificacionService.findAll();
        modelo.addAttribute("listaClasificaciones", listaClasificaciones);

        List<EstadoCartelera> listaEstadosCartelera = estadoCarteleraService.findAll();
        modelo.addAttribute("listaEstadosCartelera",listaEstadosCartelera);
        return "indexUsuario";
    }

    @GetMapping("/usuario/cartelera")
    public String listarPeliculasEnCartelera(Model modelo){
        List<Pelicula> listaPeliculas = peliculaService.findAll();
        modelo.addAttribute("listaPeliculas",listaPeliculas);

        List<Genero> listaGeneros = generoService.findAll(Sort.by("titulo"));
        modelo.addAttribute("listaGeneros",listaGeneros);

        List<Clasificacion> listaClasificaciones = clasificacionService.findAll();
        modelo.addAttribute("listaClasificaciones", listaClasificaciones);

        List<EstadoCartelera> listaEstadosCartelera = estadoCarteleraService.findAll();
        modelo.addAttribute("listaEstadosCartelera",listaEstadosCartelera);
        return "usuario/Cartelera";
    }

    @GetMapping("/usuario/peliculas")
    public String listarPeliculasEnPeliculas(Model modelo){
        List<Pelicula> listaPeliculas = peliculaService.findAll();
        modelo.addAttribute("listaPeliculas",listaPeliculas);

        List<Genero> listaGeneros = generoService.findAll(Sort.by("titulo"));
        modelo.addAttribute("listaGeneros",listaGeneros);

        List<Clasificacion> listaClasificaciones = clasificacionService.findAll();
        modelo.addAttribute("listaClasificaciones", listaClasificaciones);

        List<EstadoCartelera> listaEstadosCartelera = estadoCarteleraService.findAll();
        modelo.addAttribute("listaEstadosCartelera",listaEstadosCartelera);
        return "usuario/Peliculas";
    }

    @GetMapping("/usuario/ubicaciones")
    public String ubicaciones(Model modelo){
        return "usuario/Ubicaciones";
    }

    @GetMapping("/usuario/nosotros")
    public String nosotros(Model modelo){
        return "usuario/Nosotros";
    }

    @GetMapping("/usuario/contactanos")
    public String contactanos(Model modelo){
        return "usuario/Contactanos";
    }




}
