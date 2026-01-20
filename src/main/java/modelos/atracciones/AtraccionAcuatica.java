package modelos.atracciones;

import modelos.enums.EstadoAtraccion;
import modelos.enums.NivelRiesgo;
import modelos.mantenimiento.Mantenimiento;
import modelos.personas.Visitante;
import modelos.tickets.Ticket;

import java.util.List;

public class AtraccionAcuatica extends Atraccion {

    private boolean requiereSaberNadar;

    public AtraccionAcuatica(
            int id,
            String nombre,
            int capacidadPorTurno,
            double precioBase,
            EstadoAtraccion estado,
            NivelRiesgo riesgo,
            List<Visitante> colaVisitantes,
            List<Mantenimiento> mantenimientos,
            boolean requiereSaberNadar
    ) {
        super(id, nombre, capacidadPorTurno, precioBase, estado, riesgo, colaVisitantes, mantenimientos);
        this.requiereSaberNadar = requiereSaberNadar;
    }

    @Override
    public boolean puedeIngresar(Visitante v) {
        if (v == null) {
            throw new IllegalArgumentException("Visitante null");
        }

        if (requiereSaberNadar && !v.isSabeNadar()) {
            return false;
        }

        return true;
    }

    @Override
    public double calcularCosto(Ticket ticket) {
        double costo = super.calcularCosto(ticket);

        costo *= 1.15;

        return costo;
    }
}
