package edu.daw.samu.PokemonVGC.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.* ;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Torneo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String lugar;
    private String tipo;
    private int maxJugadores;

    @ManyToMany
@JoinTable(
    name = "torneo_jugador",
  joinColumns = @JoinColumn(name = "torneo_id"),
inverseJoinColumns = @JoinColumn(name = "jugador_id")
)
private List<Jugador> participantes = new ArrayList<>();
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

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getMaxJugadores() {
        return maxJugadores;
    }

    public void setMaxJugadores(int maxJugadores) {
        this.maxJugadores = maxJugadores;
    }

    public List<Jugador> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Jugador> participantes) {
        this.participantes = participantes;
    }


}
