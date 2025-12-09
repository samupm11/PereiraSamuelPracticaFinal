package edu.daw.samu.PokemonVGC.model.VO;

import java.util.Objects;
import java.util.Set;
import jakarta.persistence.Embeddable;

@Embeddable
public final class Arquetipo {
    private final String valor;

    public Arquetipo(String valor) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("El arquetipo no puede estar vacío.");
        }

        //  arquetipos en el circuito VGC actual
        Set<String> arquetiposValidos = Set.of(
            "BALANCE", "TRICK_ROOM", "RAIN", "SUN", "OFFENSIVE", "PERISH_SONG", "DONDOZO"
        );

        String normalizado = valor.trim().toUpperCase();
        if (!arquetiposValidos.contains(normalizado)) {
            throw new IllegalArgumentException("Arquetipo no válido: " + normalizado +
                ". Valores permitidos: " + arquetiposValidos);
        }

        this.valor = normalizado;
    }

    protected Arquetipo() {
        this.valor = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Arquetipo arquetipo = (Arquetipo) o;

        return Objects.equals(valor, arquetipo.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public String toString() {
        return valor;
    }

    public String getValor() {
        return valor;
    }
}     