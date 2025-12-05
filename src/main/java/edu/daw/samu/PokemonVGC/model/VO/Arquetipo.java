package edu.daw.samu.PokemonVGC.model.VO;

import jakarta.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public final class Arquetipo {

    private final String valor;

    public Arquetipo(String valor) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("El arquetipo no puede ser nulo o vacío");
        }
        this.valor = valor.trim();
    }

    protected Arquetipo() {
        this.valor = "";
    }

    public String getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Arquetipo arquetipo = (Arquetipo) obj;
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
}