package edu.daw.samu.PokemonVGC.model.VO;

import jakarta.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public final class Premio {

    private final int cantidad;
    private final String moneda;

    public Premio(int cantidad, String moneda) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }
        if (moneda == null || moneda.trim().isEmpty()) {
            throw new IllegalArgumentException("La moneda no puede ser nula o vacía");
        }
        this.cantidad = cantidad;
        this.moneda = moneda.trim();
    }

    protected Premio() {
        this.cantidad = 0;
        this.moneda = "EUR";
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getMoneda() {
        return moneda;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Premio premio = (Premio) obj;
        return cantidad == premio.cantidad && Objects.equals(moneda, premio.moneda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cantidad, moneda);
    }

    @Override
    public String toString() {
        return cantidad + " " + moneda;
    }
}