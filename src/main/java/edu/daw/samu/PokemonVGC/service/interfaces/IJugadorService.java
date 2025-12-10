package edu.daw.samu.PokemonVGC.service.interfaces;

import java.util.List;
import java.util.Optional;

import edu.daw.samu.PokemonVGC.model.Jugador;

public interface IJugadorService {
    List<Jugador> obtenerTodos();
    Optional<Jugador> obtenerPorId(Long id);
    Jugador crear(String nombre, String nacionalidad, String arquetipoStr, Long equipoId);
    Jugador actualizar(Long id, String nombre, String nacionalidad, String arquetipoStr, Long equipoId);
    void borrar(Long id);
}