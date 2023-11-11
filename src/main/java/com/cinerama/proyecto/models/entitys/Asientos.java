package com.cinerama.proyecto.models.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.*;

import javax.persistence.*;

@Entity
@Table(name = "asientos")
@ToString @EqualsAndHashCode
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Asientos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //para valores con auto increment
    @Getter @Setter @Column(name = "id")
    private Long id;

    @JsonBackReference(value="function-details")
    @ManyToOne(fetch = FetchType.EAGER)
    @Getter @Setter
    @JoinColumn(name = "funcion_id")
    private Funcion funcion;

    @Getter @Setter @Column(name = "costo")
    private String costo;

    @Getter @Setter @Column(name = "asiento")
    private String asiento;

    @Getter @Setter @Column(name = "fecha")
    private LocalDateTime fecha;

    @Getter @Setter @Column(name = "idcliente")
    private String idcliente;
}
