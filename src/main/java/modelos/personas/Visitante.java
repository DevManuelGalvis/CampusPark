package modelos.personas;

public class Visitante extends Persona{
    private int edad;
    private int alturaCm;
    private boolean sabeNadar;

    public Visitante(int id, String nombre, int edad, int alturaCm, boolean sabeNadar){
        super(id, nombre);
        if (edad < 0 || edad > 120){
            throw new IllegalArgumentException("Error al ingresar la edad.");
        }
        if (alturaCm < 0 || alturaCm > 250){
            throw new IllegalArgumentException("Error al ingresar la altura.");
        }

        this.edad = edad;
        this.alturaCm = alturaCm;
        this.sabeNadar = sabeNadar;

    }

    public int getEdad() {
        return edad;
    }

    public int getAlturaCm() {
        return alturaCm;
    }

    public boolean isSabeNadar() {
        return sabeNadar;
    }
}
