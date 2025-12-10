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

import edu.daw.samu.PokemonVGC.model.Torneo;
import edu.daw.samu.PokemonVGC.model.dto.TorneoDTO;
import edu.daw.samu.PokemonVGC.service.interfaces.ITorneoService;

@RestController
@RequestMapping("/api/torneos")
public class TorneoController {

    @Autowired
    private ITorneoService torneoService;

    @GetMapping
    public List<Torneo> listarTorneos() {
        return torneoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Torneo> obtenerTorneoPorId(@PathVariable Long id) {
        return torneoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/participantes")
    public ResponseEntity<?> obtenerParticipantesDeTorneo(@PathVariable Long id) {
        return torneoService.obtenerPorId(id)
                .map(Torneo::getParticipantes)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/ranking")
    public ResponseEntity<?> obtenerRankingDeTorneo(@PathVariable Long id) {
        return ResponseEntity.ok(torneoService.obtenerRankingDeTorneo(id));
    }

    @PostMapping
    public ResponseEntity<Torneo> crearTorneo(@RequestBody TorneoDTO dto) {
        Torneo nuevo = torneoService.crearDesdeDTO(dto);
        return ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Torneo> actualizarTorneo(@PathVariable Long id, @RequestBody TorneoDTO dto) {
        Torneo actualizado = torneoService.actualizarDesdeDTO(id, dto);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTorneo(@PathVariable Long id) {
        torneoService.borrar(id);
        return ResponseEntity.noContent().build();
    }
}