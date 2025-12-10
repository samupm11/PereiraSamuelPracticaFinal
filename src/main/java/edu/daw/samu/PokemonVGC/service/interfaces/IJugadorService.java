package edu.daw.samu.PokemonVGC.service.interfaces;

import java.util.List;
import java.util.Optional;

import edu.daw.samu.PokemonVGC.model.Jugador;
import edu.daw.samu.PokemonVGC.model.dto.JugadorDTO;

public interface IJugadorService {
    List<Jugador> obtenerTodos();
    Optional<Jugador> obtenerPorId(Long id);
    Jugador crearDesdeDTO(JugadorDTO dto);
    Jugador actualizarDesdeDTO(Long id, JugadorDTO dto);
    void borrar(Long id);
}