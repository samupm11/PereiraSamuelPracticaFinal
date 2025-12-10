package edu.daw.samu.PokemonVGC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.daw.samu.PokemonVGC.model.Jugador;
import edu.samu.back.pokemonvgc.model.dto.JugadorDTO;
import edu.samu.back.pokemonvgc.mapper.JugadorMapper;
import edu.samu.back.pokemonvgc.service.interfaces.IJugadorService;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {

    @Autowired
    private IJugadorService jugadorService;

    @Autowired
    private JugadorMapper jugadorMapper;

    @GetMapping
    public List<JugadorDTO> listarJugadores() {
        return jugadorService.obtenerTodosLosJugadores().stream()
                .map(jugadorMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public JugadorDTO obtenerJugadorPorId(@PathVariable("id") Long id) {
        return jugadorMapper.toDto(jugadorService.obtenerJugadorPorId(id));
    }

    @GetMapping("/{id}/equipo")
    public Object obtenerEquipoDeJugador(@PathVariable(" id ") Long id) {
        return jugadorService.obtenerJugadorPorId(id).getEquipo();
    }

    @PostMapping("/save")
    public JugadorDTO guardarJugador(@RequestBody JugadorDTO jugadorDTO) {
        Jugador jugador = jugadorMapper.toEntity(jugadorDTO);
        Jugador guardado = jugadorService.crearJugador(jugador);
        return jugadorMapper.toDto(guardado);
    }

    @PutMapping("/update/{id}")
    public JugadorDTO actualizarJugador(@PathVariable("id") Long id, @RequestBody JugadorDTO jugadorDTO) {
        Jugador jugador = jugadorMapper.toEntity(jugadorDTO);
        Jugador actualizado = jugadorService.actualizarJugador(id, jugador);
        return jugadorMapper.toDto(actualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public JugadorDTO eliminarJugador(@PathVariable("id") Long id) {
        Jugador eliminado = jugadorService.borrarJugador(id);
        return jugadorMapper.toDto(eliminado);
    }
}