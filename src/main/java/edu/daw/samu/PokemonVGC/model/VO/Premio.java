package edu.daw.samu.PokemonVGC.model.VO;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public final class Premio {
    private final Integer cantidad;
    private final String moneda;

    public Premio(Integer cantidad, String moneda) {
        if (cantidad == null || cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad del premio debe ser mayor que cero.");
        }

        if (moneda == null || moneda.trim().isEmpty()) {
            throw new IllegalArgumentException("La moneda no puede estar vacía.");
        }

        this.cantidad = cantidad;
        this.moneda = moneda.trim().toUpperCase();
    }

    protected Premio() {
        this.cantidad = null;
        this.moneda = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Premio premio = (Premio) o;

        return Objects.equals(cantidad, premio.cantidad) &&
               Objects.equals(moneda, premio.moneda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cantidad, moneda);
    }

    @Override
    public String toString() {
        return cantidad + " " + moneda;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public String getMoneda() {
        return moneda;
    }
}