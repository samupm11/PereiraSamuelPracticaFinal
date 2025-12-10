package edu.daw.samu.PokemonVGC.mapper;

import org.springframework.stereotype.Component;

import edu.daw.samu.PokemonVGC.model.Equipo;
import edu.daw.samu.PokemonVGC.model.dto.EquipoDTO;

@Component
public class EquipoMapper {

    public EquipoDTO toDto(Equipo equipo) {
        if (equipo == null) return null;

        return new EquipoDTO(
            equipo.getId(),
            equipo.getNombre(),
            equipo.getPais()
        );
    }

    public Equipo toEntity(EquipoDTO dto) {
        if (dto == null) return null;

        Equipo equipo = new Equipo();
        equipo.setId(dto.id());
        equipo.setNombre(dto.nombre());
        equipo.setPais(dto.pais());

        return equipo;
    }
}
