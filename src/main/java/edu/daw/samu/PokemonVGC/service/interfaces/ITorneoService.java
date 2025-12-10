package edu.daw.samu.PokemonVGC.service.interfaces;

import java.util.List;
import java.util.Optional;

import edu.daw.samu.PokemonVGC.model.ResultadoTorneo;
import edu.daw.samu.PokemonVGC.model.Torneo;
import edu.daw.samu.PokemonVGC.model.dto.TorneoDTO;

public interface ITorneoService {
    List<Torneo> obtenerTodos();
    Optional<Torneo> obtenerPorId(Long id);
    Torneo crearDesdeDTO(TorneoDTO dto);
    Torneo actualizarDesdeDTO(Long id, TorneoDTO dto);
    void borrar(Long id);
    List<ResultadoTorneo> obtenerRankingDeTorneo(Long torneoId);   
}