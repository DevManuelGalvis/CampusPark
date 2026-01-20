package modelos.personas;

public abstract class Persona {
    private int id;
    private String nombre;

    public Persona(int id, String nombre){

        if(id <= 0){
            throw new IllegalArgumentException("El numero (id) debe ser mayor a cero.");
        }
        if (nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacio.");
        }

        this.id = id;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }
}
