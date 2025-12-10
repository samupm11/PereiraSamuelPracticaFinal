package edu.daw.samu.PokemonVGC.model.dto;

public record JugadorDTO(
    Long id,
    String nombre,
    String nacionalidad,
    String arquetipoFavorito,
    Long equipoId
) {}