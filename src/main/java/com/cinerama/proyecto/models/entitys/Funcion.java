package com.cinerama.proyecto.models.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Funcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonBackReference(value="movies-details")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pelicula_id")
    private Pelicula pelicula;

    @JsonBackReference(value="sede-details")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sede_id")
    private Sede sede;

    @JsonBackReference(value="sala-details")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sala_id")
    private Sala sala;

    private String horario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Funcion() {
        super();
    }

    public Funcion(Integer id, Pelicula pelicula, Sede sede, Sala sala, String horario) {
        super();
        this.id = id;
        this.pelicula = pelicula;
        this.sede = sede;
        this.sala = sala;
        this.horario = horario;
    }

    public Funcion(Pelicula pelicula, Sede sede, Sala sala, String horario) {
        super();
        this.pelicula = pelicula;
        this.sede = sede;
        this.sala = sala;
        this.horario = horario;
    }

    public Funcion(Pelicula pelicula) {
        super();
        this.pelicula = pelicula;
    }

    @Override
    public String toString() {
        return "Funcion{" +
                "pelicula=" + pelicula +
                '}';
    }
}
