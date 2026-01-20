package modelos.atracciones;

import interfaces.CalculableCosto;
import interfaces.Inspeccionable;
import modelos.enums.EstadoAtraccion;
import modelos.enums.NivelRiesgo;
import modelos.enums.TipoTicket;
import modelos.mantenimiento.Mantenimiento;
import modelos.personas.Empleado;
import modelos.personas.Visitante;
import modelos.tickets.Ticket;

import java.time.LocalDate;
import java.util.List;

public abstract class Atraccion implements Inspeccionable, CalculableCosto {
    private int id;
    private String nombre;
    protected int capacidadPorTurno;
    protected double precioBase;
    protected EstadoAtraccion estado;
    protected NivelRiesgo riesgo;
    protected List<Visitante> colaVisitantes;
    protected List<Mantenimiento> mantenimientos;
    protected List<Ticket> ticketsTurno;


    public Atraccion(int id, String nombre, int capacidadPorTurno, double precioBase,
                     EstadoAtraccion estado, NivelRiesgo riesgo, List<Visitante> colaVisitantes, List<Mantenimiento> mantenimientos){
        if (id <= 0){
            throw new IllegalArgumentException("ERROR: El numero (id) debe ser mayor a cero.");
        }

        if (nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("ERROR: El nombre no puede estar vacio.");
        }

        if (capacidadPorTurno <= 0){
            throw new IllegalArgumentException("ERROR: La capacidad por turno debe ser mayor a cero");
        }

        if (precioBase < 0){
            throw new IllegalArgumentException("ERROR: No se aceptan numero negativos!!");
        }

        if (estado == null){
            throw new IllegalArgumentException("ERROR: El estado no puede estar vacio.");
        }

        if (riesgo == null){
            throw new IllegalArgumentException("ERROR: El campo (Riesgo) no puede estar vacio.");
        }

        if (colaVisitantes == null){
            throw new IllegalArgumentException("Error: No puede ingresar campos vacios en colaVisitantes.");
        }

        if (mantenimientos == null) {
            throw new IllegalArgumentException("ERROR: La lista de mantenimientos no puede ser null.");
        }


        this.id = id;
        this.capacidadPorTurno = capacidadPorTurno;
        this.nombre = nombre;
        this.estado = estado;
        this.colaVisitantes = colaVisitantes;
        this.riesgo = riesgo;
        this.precioBase = precioBase;
        this.mantenimientos = mantenimientos;
    }
/*
    public boolean estaOperativa() {
        return estado == EstadoAtraccion.OPERATIVA;
    }
*/
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract boolean puedeIngresar(Visitante v);
    /*public abstract void encolarVisitante(Visitante v);*/
    /*public abstract double operarTurno();*/

    @Override
    public boolean estaOperativa() {
        return estado == EstadoAtraccion.OPERATIVA;
    }

    public void encolarVisitante(Visitante v) {
        if (v == null) {
            throw new IllegalArgumentException("El visitante no puede ser null.");
        }

        if (!estaOperativa()) {
            throw new IllegalStateException("La atracción no está operativa.");
        }

        if (!puedeIngresar(v)) {
            throw new IllegalArgumentException("El visitante no cumple los requisitos.");
        }

        colaVisitantes.add(v);
    }

    public double operarTurno() {

        if (!estaOperativa()) {
            throw new IllegalStateException("La atracción no está operativa");
        }

        int cantidad = Math.min(capacidadPorTurno, ticketsTurno.size());
        double recaudo = 0;

        for (int i = 0; i < cantidad; i++) {
            Ticket t = ticketsTurno.remove(0); // sale del turno
            recaudo += calcularCosto(t);
        }

        return recaudo;
    }



    @Override
    public double calcularCosto(Ticket ticket) {
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket no puede ser null");
        }

        double costo = precioBase;

        if (ticket.getTipo() == TipoTicket.VIP) {
            costo *= 0.9; // 10% descuento base
        }

        return costo;
    }

    @Override
    public void registrarMantenimiento(Empleado e, String notas) {
        if (e == null) {
            throw new IllegalArgumentException("Empleado null");
        }

        Mantenimiento m = new Mantenimiento(LocalDate.now(), e, notas);
        mantenimientos.add(m);
        this.estado = EstadoAtraccion.EN_MANTENIMIENTO;
    }

    public List<Visitante> getColaVisitantes() {
        return colaVisitantes;
    }

}
