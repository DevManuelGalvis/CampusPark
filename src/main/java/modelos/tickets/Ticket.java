package modelos.tickets;

import modelos.enums.TipoTicket;
import modelos.personas.Visitante;

import java.util.Date;

public class Ticket {
    private int id;
    private TipoTicket tipo;
    private Visitante visitante;
    private Date fechaCompra;

    public Ticket(int id, TipoTicket tipo, Visitante visitante, Date fechaCompra){

        if (id <= 0){
            throw new IllegalArgumentException("ERROR: Ingresa un valor mayor a cero.");
        }

        if (tipo == null){
            throw new IllegalArgumentException("ERROR: No puede ingresar un valor vacio para el tipo.");
        }

        if (visitante == null){
            throw new IllegalArgumentException("ERROR: No puede ingresar un valor vacio para el visitante.");
        }

        if (fechaCompra == null) {
            throw new IllegalArgumentException("ERROR: La fecha de compra no puede ser null.");
        }

        this.id = id;
        this.tipo = tipo;
        this.visitante = visitante;
        this.fechaCompra = fechaCompra;
    }

    public int getId() {
        return id;
    }

    public TipoTicket getTipo() {
        return tipo;
    }

    public Visitante getVisitante() {
        return visitante;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }
}
