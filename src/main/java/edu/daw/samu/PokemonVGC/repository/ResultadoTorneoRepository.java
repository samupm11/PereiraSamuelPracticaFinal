
package edu.daw.samu.PokemonVGC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.daw.samu.PokemonVGC.model.ResultadoTorneo;

@Repository
public interface ResultadoTorneoRepository extends JpaRepository<ResultadoTorneo, Long> {
    List<ResultadoTorneo> findByTorneo_IdOrderByPosicionFinalAsc(Long torneoId);
}