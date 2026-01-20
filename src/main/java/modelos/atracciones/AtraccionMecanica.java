package modelos.atracciones;

import modelos.enums.EstadoAtraccion;
import modelos.enums.NivelRiesgo;
import modelos.mantenimiento.Mantenimiento;
import modelos.personas.Visitante;
import modelos.tickets.Ticket;

import java.util.List;

public class AtraccionMecanica extends Atraccion {

    private int alturaMinimaCm;

    public AtraccionMecanica(
            int id,
            String nombre,
            int capacidadPorTurno,
            double precioBase,
            EstadoAtraccion estado,
            NivelRiesgo riesgo,
            List<Visitante> colaVisitantes,
            List<Mantenimiento> mantenimientos,
            int alturaMinimaCm
    ) {
        super(id, nombre, capacidadPorTurno, precioBase, estado, riesgo, colaVisitantes, mantenimientos);

        if (alturaMinimaCm <= 0) {
            throw new IllegalArgumentException("La altura mínima debe ser mayor a cero");
        }

        this.alturaMinimaCm = alturaMinimaCm;
    }

    @Override
    public boolean puedeIngresar(Visitante v) {
        if (v == null) {
            throw new IllegalArgumentException("Visitante null");
        }

        return v.getAlturaCm() >= alturaMinimaCm;
    }

    @Override
    public double calcularCosto(Ticket ticket) {
        double costo = super.calcularCosto(ticket);

        // 15% recargo por riesgo mecánico
        costo *= 1.15;

        return costo;
    }
}
