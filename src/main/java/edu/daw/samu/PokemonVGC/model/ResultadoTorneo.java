package edu.daw.samu.PokemonVGC.model;

import edu.daw.samu.PokemonVGC.model.VO.Premio;
import jakarta.persistence.Embedded;
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

    private int posicionFinal;
    private int puntosObtenidos;
    
    @Embedded
    private Premio premioEuros;

     @ManyToOne
     @JoinColumn(name = "jugador_id")
     private Jugador jugador;

     @ManyToOne
     @JoinColumn(name = "torneo_id")
     private Torneo torneo;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
}