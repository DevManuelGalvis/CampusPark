package interfaces;

import modelos.tickets.Ticket;

public interface CalculableCosto {
    double calcularCosto(Ticket t);
    boolean estaOperativa();
}
