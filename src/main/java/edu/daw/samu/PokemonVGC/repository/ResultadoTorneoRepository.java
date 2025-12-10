package edu.daw.samu.PokemonVGC.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.daw.samu.PokemonVGC.model.ResultadoTorneo;
import edu.daw.samu.PokemonVGC.model.Torneo;

@Repository
public interface ResultadoTorneoRepository extends JpaRepository<ResultadoTorneo, Long> {
    List<ResultadoTorneo> findByTorneo(Torneo torneo);
    Optional<ResultadoTorneo> findByTorneoAndPosicionFinal(Torneo torneo, int posicion);
}