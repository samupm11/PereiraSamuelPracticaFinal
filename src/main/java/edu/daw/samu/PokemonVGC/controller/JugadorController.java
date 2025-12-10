package edu.daw.samu.PokemonVGC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.daw.samu.PokemonVGC.model.Equipo;
import edu.daw.samu.PokemonVGC.model.Jugador;
import edu.daw.samu.PokemonVGC.model.dto.JugadorDTO;
import edu.daw.samu.PokemonVGC.service.interfaces.IJugadorService;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {

    @Autowired
    private IJugadorService jugadorService;

    @GetMapping
    public List<Jugador> listarJugadores() {
        return jugadorService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jugador> obtenerJugadorPorId(@PathVariable Long id) {
        return jugadorService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/equipo")
    public ResponseEntity<Equipo> obtenerEquipoDeJugador(@PathVariable Long id) {
        return jugadorService.obtenerPorId(id)
                .map(Jugador::getEquipo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Jugador> crearJugador(@RequestBody JugadorDTO dto) {
        Jugador nuevo = jugadorService.crearDesdeDTO(dto);
        return ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jugador> actualizarJugador(@PathVariable Long id, @RequestBody JugadorDTO dto) {
        Jugador actualizado = jugadorService.actualizarDesdeDTO(id, dto);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarJugador(@PathVariable Long id) {
        jugadorService.borrar(id);
        return ResponseEntity.noContent().build();
    }
}