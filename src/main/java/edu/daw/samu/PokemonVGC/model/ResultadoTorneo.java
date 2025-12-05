package edu.daw.samu.PokemonVGC.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ResultadoTorneo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "jugador_id")
    private Jugador jugador;

    @ManyToOne
    @JoinColumn(name = "torneo_id")
    private Torneo torneo;

    private int posicionFinal;
    private int puntosObtenidos;
    private int premioEuros;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Jugador getJugador() {
        return jugador;
    }
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    public Torneo getTorneo() {
        return torneo;
    }
    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }
    public int getPosicionFinal() {
        return posicionFinal;
    }
    public void setPosicionFinal(int posicionFinal) {
        this.posicionFinal = posicionFinal;
    }
    public int getPuntosObtenidos() {
        return puntosObtenidos;
    }
    public void setPuntosObtenidos(int puntosObtenidos) {
        this.puntosObtenidos = puntosObtenidos;
    }
    public int getPremioEuros() {
        return premioEuros;
    }
    public void setPremioEuros(int premioEuros) {
        this.premioEuros = premioEuros;
    }

}