package edu.daw.samu.PokemonVGC.model;

import org.apache.poi.ss.formula.functions.Columns;

import edu.daw.samu.PokemonVGC.model.VO.Arquetipo;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String nacionalidad;
  
    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    @Embedded
    @AttributeOverride(name = "valor", column = Columns(name = "arquetipoFavorito"))
    private Arquetipo arquetipoFavorito;

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

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Arquetipo getArquetipoFavorito() {
        return arquetipoFavorito;
    }

    public void setArquetipoFavorito(Arquetipo arquetipoFavorito) {
        this.arquetipoFavorito = arquetipoFavorito;
    }

 
}