package edu.daw.samu.PokemonVGC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.daw.samu.PokemonVGC.model.Equipo;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {
}