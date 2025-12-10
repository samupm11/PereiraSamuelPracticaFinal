package edu.daw.samu.PokemonVGC.model;

import edu.daw.samu.PokemonVGC.model.VO.Premio;
import jakarta.persistence.*;

@Entity
@Table(name = "resultado_torneo")
public class ResultadoTorneo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "jugador_id", nullable = false)
    private Jugador jugador;

    @ManyToOne
    @JoinColumn(name = "torneo_id", nullable = false)
    private Torneo torneo;

    @Column(name = "posicion_final", nullable = false)
    private int posicionFinal;

    @Column(name = "puntos_obtenidos", nullable = false)
    private int puntosObtenidos;

    @Embedded
    @AttributeOverride(name = "cantidad", column = @Column(name = "premio_cantidad"))
    @AttributeOverride(name = "moneda", column = @Column(name = "premio_moneda"))
    private Premio premio;

    // 👇 Constructor protegido requerido por JPA
    protected ResultadoTorneo() {}

    // Getters y setters (ya los tienes bien)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Jugador getJugador() { return jugador; }
    public void setJugador(Jugador jugador) { this.jugador = jugador; }

    public Torneo getTorneo() { return torneo; }
    public void setTorneo(Torneo torneo) { this.torneo = torneo; }

    public int getPosicionFinal() { return posicionFinal; }
    public void setPosicionFinal(int posicionFinal) { this.posicionFinal = posicionFinal; }

    public int getPuntosObtenidos() { return puntosObtenidos; }
    public void setPuntosObtenidos(int puntosObtenidos) { this.puntosObtenidos = puntosObtenidos; }

    public Premio getPremio() { return premio; }
    public void setPremio(Premio premio) { this.premio = premio; }
}