package edu.daw.samu.PokemonVGC.service.interfaces;

import java.util.List;
import java.util.Optional;
import edu.daw.samu.PokemonVGC.model.Torneo;

public interface ITorneoService {

    List<Torneo> obtenerTodos();

    Optional<Torneo> obtenerPorId(Long id);

    Torneo crear(String nombre, String lugar, String tipo, int maxJugadores);

    Torneo actualizar(Long id, String nombre, String lugar, String tipo, int maxJugadores);

    void borrar(Long id);
}