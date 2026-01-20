package modelos.atracciones;

import modelos.enums.EstadoAtraccion;
import modelos.enums.NivelRiesgo;
import modelos.mantenimiento.Mantenimiento;
import modelos.personas.Visitante;
import modelos.tickets.Ticket;

import java.util.List;

public class AtraccionInfantil extends Atraccion {

    private int edadMaxima;

    public AtraccionInfantil(
            int id,
            String nombre,
            int capacidadPorTurno,
            double precioBase,
            EstadoAtraccion estado,
            NivelRiesgo riesgo,
            List<Visitante> colaVisitantes,
            List<Mantenimiento> mantenimientos,
            int edadMaxima
    ) {
        super(id, nombre, capacidadPorTurno, precioBase, estado, riesgo, colaVisitantes, mantenimientos);

        if (edadMaxima <= 0) {
            throw new IllegalArgumentException("Edad máxima debe ser mayor a cero");
        }

        this.edadMaxima = edadMaxima;
    }

    @Override
    public boolean puedeIngresar(Visitante v) {
        if (v == null) {
            throw new IllegalArgumentException("Visitante null");
        }

        return v.getEdad() <= edadMaxima;
    }

    @Override
    public double calcularCosto(Ticket ticket) {
        double costo = super.calcularCosto(ticket);

        // 20% descuento adicional
        costo *= 0.8;

        return costo;
    }
}
