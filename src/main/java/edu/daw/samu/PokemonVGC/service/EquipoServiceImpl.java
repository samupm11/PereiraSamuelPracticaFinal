package edu.daw.samu.PokemonVGC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.daw.samu.PokemonVGC.model.Equipo;
import edu.daw.samu.PokemonVGC.repository.EquipoRepository;
import edu.daw.samu.PokemonVGC.service.interfaces.IEquipoService;

@Service
public class EquipoServiceImpl implements IEquipoService {

    private final EquipoRepository equipoRepository;

    public EquipoServiceImpl(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    @Override
    public List<Equipo> obtenerTodos() {
        return equipoRepository.findAll();
    }

    @Override
    public Optional<Equipo> obtenerPorId(Long id) {
        return equipoRepository.findById(id);
    }

    @Override
    public Equipo crear(String nombre, String pais) {
        Equipo equipo = new Equipo();
        equipo.setNombre(nombre);
        equipo.setPais(pais);
        return equipoRepository.save(equipo);
    }

    @Override
    public Equipo actualizar(Long id, String nombre, String pais) {
        return equipoRepository.findById(id)
            .map(equipo -> {
                equipo.setNombre(nombre);
                equipo.setPais(pais);
                return equipoRepository.save(equipo);
            })
            .orElseThrow(() -> new RuntimeException("Equipo no encontrado con ID: " + id));
    }

    @Override
    public void borrar(Long id) {
        equipoRepository.deleteById(id);
    }
}