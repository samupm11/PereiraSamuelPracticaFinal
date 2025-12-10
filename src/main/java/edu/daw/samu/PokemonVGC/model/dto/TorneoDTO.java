package edu.daw.samu.PokemonVGC.model.dto;


public record TorneoDTO(
    Long id,
    String nombre,
    String lugar,
    String tipo,
    int maxJugadores
) {}