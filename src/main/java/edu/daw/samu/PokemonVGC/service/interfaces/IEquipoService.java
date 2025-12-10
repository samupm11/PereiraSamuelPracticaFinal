package edu.daw.samu.PokemonVGC.service.interfaces;

import java.util.List;
import java.util.Optional;

import edu.daw.samu.PokemonVGC.model.Equipo;

public interface IEquipoService {
    List<Equipo> obtenerTodos();
    Optional<Equipo> obtenerPorId(Long id);
    Equipo crear(String nombre, String pais);
    Equipo actualizar(Long id, String nombre, String pais);
    void borrar(Long id);
}