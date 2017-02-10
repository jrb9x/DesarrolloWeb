package Concierto;


public class Cuerda implements Instrumento {

    private String nombre;

    public Cuerda(String nombre) {
        this.nombre = nombre;
    }

    public String tocar() {
        return "Estoy rascando";
    }

    public String getNombre() {
        return nombre;
    }
}
