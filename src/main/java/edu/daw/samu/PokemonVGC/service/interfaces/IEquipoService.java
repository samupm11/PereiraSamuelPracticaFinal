package edu.daw.samu.PokemonVGC.service.interfaces;

import java.util.List;
import java.util.Optional;

import edu.daw.samu.PokemonVGC.model.Equipo;
import edu.daw.samu.PokemonVGC.model.dto.EquipoDTO;

public interface IEquipoService {
    List<Equipo> obtenerTodos();
    Optional<Equipo> obtenerPorId(Long id);
    Equipo crearDesdeDTO(EquipoDTO dto);
    Equipo actualizarDesdeDTO(Long id, EquipoDTO dto);
    void borrar(Long id);
}