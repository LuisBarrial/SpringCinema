package com.cinerama.proyecto.models.entitys;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 128, nullable = false, unique = true)
    private String nombre;

    private String duracion;

    private String youtubeTrailerId;

    private String rutaPortada;

    private Date fecha;

    @Transient
    private MultipartFile portada;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private EstadoPelicula estadop;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero generoPelicula;

    @ManyToOne
    @JoinColumn(name = "clasificacion_id")
    private Clasificacion clasificacion;

    @ManyToOne
    @JoinColumn(name = "sede_id")
    private Sede sede;

    @ManyToOne
    @JoinColumn(name = "estadoc_id")
    private EstadoCartelera estadoCartelera;

    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL)
    private List<PeliculaDetalles> detalles = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Genero getGeneroPelicula() {
        return generoPelicula;
    }

    public void setGeneroPelicula(Genero generoPelicula) {
        this.generoPelicula = generoPelicula;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

    public List<PeliculaDetalles> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<PeliculaDetalles> detalles) {
        this.detalles = detalles;
    }

    public String getYoutubeTrailerId() {
        return youtubeTrailerId;
    }

    public void setYoutubeTrailerId(String link) {
        this.youtubeTrailerId = link;
    }

    public String getRutaPortada() {
        return rutaPortada;
    }

    public void setRutaPortada(String rutaPortada) {
        this.rutaPortada = rutaPortada;
    }

    public EstadoPelicula getEstadop() {
        return estadop;
    }

    public void setEstadop(EstadoPelicula estadop) {
        this.estadop = estadop;
    }

    public void setDetalle(Integer id, String sinopsis, String director, String reparto) {
        this.detalles.add(new PeliculaDetalles(id,sinopsis,director,reparto,this));
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public EstadoCartelera getEstadoCartelera() {
        return estadoCartelera;
    }

    public void setEstadoCartelera(EstadoCartelera estadoCartelera) {
        this.estadoCartelera = estadoCartelera;
    }

    public MultipartFile getPortada() {
        return portada;
    }

    public void setPortada(MultipartFile portada) {
        this.portada = portada;
    }

    public Pelicula(Integer id, String nombre, String duracion, Genero generoPelicula, Clasificacion clasificacion, String youtubeTrailerId) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.generoPelicula = generoPelicula;
        this.clasificacion = clasificacion;
        this.youtubeTrailerId = youtubeTrailerId;
    }

    public Pelicula() {
        super();
    }

    public Pelicula(Integer id) {
        super();
        this.id = id;
    }

    public Pelicula(String nombre, String duracion) {
        super();
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public Pelicula(String nombre) {
        super();
        this.nombre = nombre;
    }

    public Pelicula(String nombre, String duracion, Genero generoPelicula, Clasificacion clasificacion, String youtubeTrailerId) {
        super();
        this.nombre = nombre;
        this.duracion = duracion;
        this.generoPelicula = generoPelicula;
        this.clasificacion = clasificacion;
        this.youtubeTrailerId = youtubeTrailerId;
    }

    public Pelicula(Integer id, String nombre, String duracion, String youtubeTrailerId, String rutaPortada, Date fecha, MultipartFile portada, EstadoPelicula estadop, Genero generoPelicula, Clasificacion clasificacion, Sede sede, EstadoCartelera estadoCartelera, List<PeliculaDetalles> detalles) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.youtubeTrailerId = youtubeTrailerId;
        this.rutaPortada = rutaPortada;
        this.fecha = fecha;
        this.portada = portada;
        this.estadop = estadop;
        this.generoPelicula = generoPelicula;
        this.clasificacion = clasificacion;
        this.sede = sede;
        this.estadoCartelera = estadoCartelera;
        this.detalles = detalles;
    }

    public Pelicula(String nombre, String duracion, String youtubeTrailerId, String rutaPortada, Date fecha, MultipartFile portada, EstadoPelicula estadop, Genero generoPelicula, Clasificacion clasificacion, Sede sede, EstadoCartelera estadoCartelera, List<PeliculaDetalles> detalles) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.youtubeTrailerId = youtubeTrailerId;
        this.rutaPortada = rutaPortada;
        this.fecha = fecha;
        this.portada = portada;
        this.estadop = estadop;
        this.generoPelicula = generoPelicula;
        this.clasificacion = clasificacion;
        this.sede = sede;
        this.estadoCartelera = estadoCartelera;
        this.detalles = detalles;
    }

    public void añadirDetalles(String sinopsis, String director, String reparto){
        this.detalles.add(new PeliculaDetalles(sinopsis,director,reparto,this));
    }

    @Override
    public String toString() {
        return nombre;
    }
}
