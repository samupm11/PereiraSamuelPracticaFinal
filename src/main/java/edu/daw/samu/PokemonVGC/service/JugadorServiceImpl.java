package edu.daw.samu.PokemonVGC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.daw.samu.PokemonVGC.model.Jugador;
import edu.daw.samu.PokemonVGC.model.Equipo;
import edu.daw.samu.PokemonVGC.model.dto.JugadorDTO;
import edu.daw.samu.PokemonVGC.model.VO.Arquetipo;
import edu.daw.samu.PokemonVGC.repository.JugadorRepository;
import edu.daw.samu.PokemonVGC.repository.EquipoRepository;
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
    public Jugador crearDesdeDTO(JugadorDTO dto) {
        Jugador jugador = new Jugador();
        jugador.setNombre(dto.nombre());
        jugador.setNacionalidad(dto.nacionalidad());

        if (dto.arquetipoFavorito() != null && !dto.arquetipoFavorito().trim().isEmpty()) {
            jugador.setArquetipoFavorito(new Arquetipo(dto.arquetipoFavorito()));
        }

        if (dto.equipoId() != null) {
            Equipo equipo = equipoRepository.findById(dto.equipoId())
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado con ID: " + dto.equipoId()));
            jugador.setEquipo(equipo);
        }

        return jugadorRepository.save(jugador);
    }

    @Override
    public Jugador actualizarDesdeDTO(Long id, JugadorDTO dto) {
        return jugadorRepository.findById(id)
            .map(jugador -> {
                jugador.setNombre(dto.nombre());
                jugador.setNacionalidad(dto.nacionalidad());

                if (dto.arquetipoFavorito() != null && !dto.arquetipoFavorito().trim().isEmpty()) {
                    jugador.setArquetipoFavorito(new Arquetipo(dto.arquetipoFavorito()));
                } else {
                    jugador.setArquetipoFavorito(null);
                }

                if (dto.equipoId() != null) {
                    Equipo equipo = equipoRepository.findById(dto.equipoId())
                        .orElseThrow(() -> new RuntimeException("Equipo no encontrado con ID: " + dto.equipoId()));
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