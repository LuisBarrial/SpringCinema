package com.cinerama.proyecto.models.entitys;

import javax.persistence.*;

@Entity
public class Clasificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, nullable = false, unique = true)
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

    public Clasificacion(Integer id, String nombre) {
        super();
        this.id = id;
        this.nombre = nombre;
    }

    public Clasificacion() {
        super();
    }

    public Clasificacion(Integer id) {
        super();
        this.id = id;
    }

    public Clasificacion(String nombre) {
        super();
        this.nombre = nombre;
    }
}
