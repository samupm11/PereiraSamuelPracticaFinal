package edu.daw.samu.PokemonVGC.model;

import edu.daw.samu.PokemonVGC.model.VO.Arquetipo;
import jakarta.persistence.*;

@Entity
@Table(name = "jugador")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "nacionalidad", nullable = false)
    private String nacionalidad;

    @Embedded
    @AttributeOverride(
        name = "valor",
        column = @Column(name = "arquetipoFavorito")
    )
    private Arquetipo arquetipoFavorito;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    public Jugador() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Arquetipo getArquetipoFavorito() {
        return arquetipoFavorito;
    }

    public void setArquetipoFavorito(Arquetipo arquetipoFavorito) {
        this.arquetipoFavorito = arquetipoFavorito;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}
