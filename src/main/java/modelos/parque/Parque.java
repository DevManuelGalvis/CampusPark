package modelos.parque;

import modelos.atracciones.Atraccion;

import java.util.ArrayList;
import java.util.List;

public class Parque {

    private String nombre;
    private List<Atraccion> atracciones;
    private double recaudoTotal;

    public Parque(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del parque no puede estar vacío.");
        }
        this.nombre = nombre;
        this.atracciones = new ArrayList<>();
        this.recaudoTotal = 0;
    }

    public void agregarAtraccion(Atraccion a) {
        if (a == null) {
            throw new IllegalArgumentException("La atracción no puede ser null.");
        }
        atracciones.add(a);
    }

    public void operarAtraccion(Atraccion a) {
        double recaudoTurno = a.operarTurno();
        recaudoTotal += recaudoTurno;
    }

    public double getRecaudoTotal() {
        return recaudoTotal;
    }

    public List<Atraccion> getAtracciones() {
        return atracciones;
    }

    public void mostrarColas() {
        for (Atraccion a : atracciones) {
            System.out.println(
                    "Atracción: " + a.getNombre() +
                            " | En cola: " + a.getColaVisitantes().size()
            );
        }
    }
}
