package com.cinerama.proyecto.models.entitys;

import groovy.transform.ToString;

import javax.persistence.*;

@Entity
@ToString
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 128, nullable = false, unique = true)
    private String nombre;

    private Integer nroAsientos;

    @ManyToOne
    @JoinColumn(name = "sede_id")
    private Sede sede;

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

    public Integer getNroAsientos() {
        return nroAsientos;
    }

    public void setNroAsientos(Integer nroAsientos) {
        this.nroAsientos = nroAsientos;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public Sala() {
        super();
    }

    public Sala(Integer id, String nombre, Integer nroAsientos, Sede sede) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.nroAsientos = nroAsientos;
        this.sede = sede;
    }

    public Sala(String nombre, Integer nroAsientos, Sede sede) {
        super();
        this.nombre = nombre;
        this.nroAsientos = nroAsientos;
        this.sede = sede;
    }

    public Sala(Integer id) {
        super();
        this.id = id;
    }

    public Sala(String nombre) {
        super();
        this.nombre = nombre;
    }
}
