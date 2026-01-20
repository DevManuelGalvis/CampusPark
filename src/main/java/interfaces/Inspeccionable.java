package interfaces;

import modelos.personas.Empleado;

public interface Inspeccionable {
    void registrarMantenimiento(Empleado e, String notas);
}
