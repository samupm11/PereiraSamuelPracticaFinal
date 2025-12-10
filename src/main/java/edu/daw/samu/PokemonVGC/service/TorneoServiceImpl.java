package edu.daw.samu.PokemonVGC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.daw.samu.PokemonVGC.model.ResultadoTorneo;
import edu.daw.samu.PokemonVGC.model.Torneo;
import edu.daw.samu.PokemonVGC.model.dto.TorneoDTO;
import edu.daw.samu.PokemonVGC.repository.TorneoRepository;
import edu.daw.samu.PokemonVGC.repository.ResultadoTorneoRepository;
import edu.daw.samu.PokemonVGC.service.interfaces.ITorneoService;

@Service
public class TorneoServiceImpl implements ITorneoService {

    private final TorneoRepository torneoRepository;
    private final ResultadoTorneoRepository resultadoTorneoRepository;

    public TorneoServiceImpl(TorneoRepository torneoRepository, ResultadoTorneoRepository resultadoTorneoRepository) {
        this.torneoRepository = torneoRepository;
        this.resultadoTorneoRepository = resultadoTorneoRepository;
    }

    @Override
    public List<ResultadoTorneo> obtenerRankingDeTorneo(Long torneoId) {
        return resultadoTorneoRepository.findByTorneo_IdOrderByPosicionFinalAsc(torneoId);
    }

    @Override
    public List<Torneo> obtenerTodos() {
        return torneoRepository.findAll();
    }

    @Override
    public Optional<Torneo> obtenerPorId(Long id) {
        return torneoRepository.findById(id);
    }

    @Override
    public Torneo crearDesdeDTO(TorneoDTO dto) {
        Torneo torneo = new Torneo();
        torneo.setNombre(dto.nombre());
        torneo.setLugar(dto.lugar());
        torneo.setTipo(dto.tipo());
        torneo.setMaxJugadores(dto.maxJugadores());
        return torneoRepository.save(torneo);
    }

    @Override
    public Torneo actualizarDesdeDTO(Long id, TorneoDTO dto) {
        return torneoRepository.findById(id)
            .map(torneo -> {
                torneo.setNombre(dto.nombre());
                torneo.setLugar(dto.lugar());
                torneo.setTipo(dto.tipo());
                torneo.setMaxJugadores(dto.maxJugadores());
                return torneoRepository.save(torneo);
            })
            .orElseThrow(() -> new RuntimeException("Torneo no encontrado con ID: " + id));
    }

    @Override
    public void borrar(Long id) {
        torneoRepository.deleteById(id);
    }
}