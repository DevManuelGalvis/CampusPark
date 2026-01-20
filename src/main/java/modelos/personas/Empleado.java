package modelos.personas;

public class Empleado extends Persona {
    private String cargo;

    public Empleado(int id, String nombre, String cargo){
        super(id,nombre);

        if (cargo == null || cargo.trim().isEmpty()){
            throw new IllegalArgumentException("Error al ingresar el cargo del empleado.");
        }

        this.cargo = cargo;
    }
}
