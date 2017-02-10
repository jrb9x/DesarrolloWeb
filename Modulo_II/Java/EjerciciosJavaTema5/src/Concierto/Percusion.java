package Concierto;


public class Percusion implements Instrumento {

    private String nombre;

    public Percusion(String nombre) {
        this.nombre = nombre;
    }

    public String tocar() {
        return "Estoy golpeando";
    }

    public String getNombre() {
        return nombre;
    }
}
