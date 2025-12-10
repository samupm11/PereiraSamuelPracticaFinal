package edu.daw.samu.PokemonVGC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.daw.samu.PokemonVGC.model.Equipo;
import edu.daw.samu.PokemonVGC.model.Jugador;
import edu.daw.samu.PokemonVGC.model.VO.Arquetipo;
import edu.daw.samu.PokemonVGC.repository.EquipoRepository;
import edu.daw.samu.PokemonVGC.repository.JugadorRepository;
import edu.daw.samu.PokemonVGC.service.interfaces.IJugadorService;

@Service
public class JugadorServiceImpl implements IJugadorService {

    private final JugadorRepository jugadorRepository;
    private final EquipoRepository equipoRepository;

    public JugadorServiceImpl(JugadorRepository jugadorRepository, EquipoRepository equipoRepository) {
        this.jugadorRepository = jugadorRepository;
        this.equipoRepository = equipoRepository;
    }

    @Override
    public List<Jugador> obtenerTodos() {
        return jugadorRepository.findAll();
    }

    @Override
    public Optional<Jugador> obtenerPorId(Long id) {
        return jugadorRepository.findById(id);
    }

    @Override
    public Jugador crear(String nombre, String nacionalidad, String arquetipoStr, Long equipoId) {
        Jugador jugador = new Jugador();
        jugador.setNombre(nombre);
        jugador.setNacionalidad(nacionalidad);
        
        if (arquetipoStr != null && !arquetipoStr.trim().isEmpty()) {
            jugador.setArquetipoFavorito(new Arquetipo(arquetipoStr));
        }

        if (equipoId != null) {
            Equipo equipo = equipoRepository.findById(equipoId)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado con ID: " + equipoId));
            jugador.setEquipo(equipo);
        }

        return jugadorRepository.save(jugador);
    }

    @Override
    public Jugador actualizar(Long id, String nombre, String nacionalidad, String arquetipoStr, Long equipoId) {
        return jugadorRepository.findById(id)
            .map(jugador -> {
                jugador.setNombre(nombre);
                jugador.setNacionalidad(nacionalidad);
                
                if (arquetipoStr != null && !arquetipoStr.trim().isEmpty()) {
                    jugador.setArquetipoFavorito(new Arquetipo(arquetipoStr));
                } else {
                    jugador.setArquetipoFavorito(null);
                }

                if (equipoId != null) {
                    Equipo equipo = equipoRepository.findById(equipoId)
                        .orElseThrow(() -> new RuntimeException("Equipo no encontrado con ID: " + equipoId));
                    jugador.setEquipo(equipo);
                } else {
                    jugador.setEquipo(null);
                }

                return jugadorRepository.save(jugador);
            })
            .orElseThrow(() -> new RuntimeException("Jugador no encontrado con ID: " + id));
    }

    @Override
    public void borrar(Long id) {
        jugadorRepository.deleteById(id);
    }
}