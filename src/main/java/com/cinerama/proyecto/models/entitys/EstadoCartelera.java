package com.cinerama.proyecto.models.entitys;

import javax.persistence.*;

@Entity
public class EstadoCartelera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 128, nullable = false, unique = true)
    private String nombre;

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

    public EstadoCartelera(Integer id, String nombre) {
        super();
        this.id = id;
        this.nombre = nombre;
    }

    public EstadoCartelera(Integer id) {
        super();
        this.id = id;
    }

    public EstadoCartelera(String nombre) {
        super();
        this.nombre = nombre;
    }

    public EstadoCartelera() {
    }
}
