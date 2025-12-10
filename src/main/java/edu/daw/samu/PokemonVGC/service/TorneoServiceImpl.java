package edu.daw.samu.PokemonVGC.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import edu.daw.samu.PokemonVGC.model.Torneo;
import edu.daw.samu.PokemonVGC.repository.TorneoRepository;
import edu.daw.samu.PokemonVGC.service.interfaces.ITorneoService;

@Service
public class TorneoServiceImpl implements ITorneoService {

    private final TorneoRepository torneoRepository;

    public TorneoServiceImpl(TorneoRepository torneoRepository) {
        this.torneoRepository = torneoRepository;
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
    public Torneo crear(String nombre, String lugar, String tipo, int maxJugadores) {
        Torneo torneo = new Torneo();
        torneo.setNombre(nombre);
        torneo.setLugar(lugar);
        torneo.setTipo(tipo);
        torneo.setMaxJugadores(maxJugadores);
        return torneoRepository.save(torneo);
    }

    @Override
    public Torneo actualizar(Long id, String nombre, String lugar, String tipo, int maxJugadores) {
        return torneoRepository.findById(id)
            .map(torneo -> {
                torneo.setNombre(nombre);
                torneo.setLugar(lugar);
                torneo.setTipo(tipo);
                torneo.setMaxJugadores(maxJugadores);
                return torneoRepository.save(torneo);
            })
            .orElseThrow(() -> new RuntimeException("Torneo no encontrado con ID: " + id));
    }

    @Override
    public void borrar(Long id) {
        torneoRepository.deleteById(id);
    }
}