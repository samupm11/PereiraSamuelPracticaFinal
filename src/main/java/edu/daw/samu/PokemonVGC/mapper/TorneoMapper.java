package edu.daw.samu.PokemonVGC.mapper;

import org.springframework.stereotype.Component;

import edu.daw.samu.PokemonVGC.model.Torneo;
import edu.daw.samu.PokemonVGC.model.dto.TorneoDTO;

@Component
public class TorneoMapper {

    public TorneoDTO toDto(Torneo torneo) {
        if (torneo == null) return null;

        return new TorneoDTO(
            torneo.getId(),
            torneo.getNombre(),
            torneo.getLugar(),
            torneo.getTipo(),
            torneo.getMaxJugadores()
        );
    }

    public Torneo toEntity(TorneoDTO dto) {
        if (dto == null) return null;

        Torneo torneo = new Torneo();
        torneo.setId(dto.id());
        torneo.setNombre(dto.nombre());
        torneo.setLugar(dto.lugar());
        torneo.setTipo(dto.tipo());
        torneo.setMaxJugadores(dto.maxJugadores());

        return torneo;
    }
}