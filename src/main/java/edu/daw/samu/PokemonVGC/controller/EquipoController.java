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
import edu.daw.samu.PokemonVGC.model.dto.EquipoDTO;
import edu.daw.samu.PokemonVGC.service.interfaces.IEquipoService;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {

    @Autowired
    private IEquipoService equipoService;

    @GetMapping
    public List<Equipo> listarEquipos() {
        return equipoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> obtenerEquipoPorId(@PathVariable Long id) {
        return equipoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/jugadores")
    public ResponseEntity<?> obtenerJugadoresDeEquipo(@PathVariable Long id) {
        return equipoService.obtenerPorId(id)
                .map(Equipo::getJugadores)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Equipo> crearEquipo(@RequestBody EquipoDTO dto) {
        Equipo nuevo = equipoService.crearDesdeDTO(dto);
        return ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipo> actualizarEquipo(@PathVariable Long id, @RequestBody EquipoDTO dto) {
        Equipo actualizado = equipoService.actualizarDesdeDTO(id, dto);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEquipo(@PathVariable Long id) {
        equipoService.borrar(id);
        return ResponseEntity.noContent().build();
    }
}