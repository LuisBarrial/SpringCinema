package com.cinerama.proyecto.models.entitys;

import javax.persistence.*;

@Entity
@Table(name = "pelicula_detalles")
public class PeliculaDetalles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, nullable = false, unique = true)
    private String sinopsis;

    @Column(length = 45, nullable = false, unique = true)
    private String director;

    @Column(length = 45, nullable = false, unique = true)
    private String reparto;

    @ManyToOne
    @JoinColumn(name = "pelicula_id")
    private Pelicula pelicula;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getReparto() {
        return reparto;
    }

    public void setReparto(String reparto) {
        this.reparto = reparto;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public PeliculaDetalles(Integer id, String sinopsis, String director, String reparto, Pelicula pelicula) {
        super();
        this.id = id;
        this.sinopsis = sinopsis;
        this.director = director;
        this.reparto = reparto;
        this.pelicula = pelicula;
    }

    public PeliculaDetalles(String sinopsis, String director, String reparto, Pelicula pelicula) {
        super();
        this.sinopsis = sinopsis;
        this.director = director;
        this.reparto = reparto;
        this.pelicula = pelicula;
    }

    public PeliculaDetalles() {
        super();
    }

    @Override
    public String toString() {
        return "PeliculaDetalles{" +
                "sinopsis='" + sinopsis + '\'' +
                ", director='" + director + '\'' +
                ", reparto='" + reparto + '\'' +
                '}';
    }
}
