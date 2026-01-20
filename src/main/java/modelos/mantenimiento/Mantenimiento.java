package modelos.mantenimiento;

import modelos.personas.Empleado;

import java.time.LocalDate;

public class Mantenimiento {
    private LocalDate fecha;
    private Empleado responsable;
    private String notas;

    public Mantenimiento(LocalDate fecha, Empleado responsable, String notas) {

        if (fecha == null) {
            throw new IllegalArgumentException("ERROR: La fecha de mantenimiento no puede ser null.");
        }

        if (responsable == null) {
            throw new IllegalArgumentException("ERROR: El responsable del mantenimiento no puede ser null.");
        }

        if (notas == null || notas.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR: Las notas del mantenimiento no pueden estar vacías.");
        }

        this.fecha = fecha;
        this.responsable = responsable;
        this.notas = notas;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Empleado getResponsable() {
        return responsable;
    }

    public String getNotas() {
        return notas;
    }
}
