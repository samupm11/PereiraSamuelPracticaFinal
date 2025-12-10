package edu.daw.samu.PokemonVGC.mapper;

import org.springframework.stereotype.Component;

import edu.daw.samu.PokemonVGC.model.Jugador;
import edu.daw.samu.PokemonVGC.model.VO.Arquetipo;
import edu.daw.samu.PokemonVGC.model.dto.JugadorDTO;

@Component
public class JugadorMapper {

    public JugadorDTO toDto(Jugador jugador) {
        if (jugador == null) return null;

        return new JugadorDTO(
            jugador.getId(),
            jugador.getNombre(),
            jugador.getNacionalidad(),
            jugador.getArquetipoFavorito() != null ? jugador.getArquetipoFavorito().getValor() : null,
            jugador.getEquipo() != null ? jugador.getEquipo().getId() : null
        );
    }

    public Jugador toEntity(JugadorDTO dto) {
        if (dto == null) return null;

        Jugador jugador = new Jugador();
        jugador.setId(dto.id()); 
        jugador.setNombre(dto.nombre());
        jugador.setNacionalidad(dto.nacionalidad());

        if (dto.arquetipoFavorito() != null && !dto.arquetipoFavorito().trim().isEmpty()) {
            jugador.setArquetipoFavorito(new Arquetipo(dto.arquetipoFavorito()));
        }

    

        return jugador;
    }
}