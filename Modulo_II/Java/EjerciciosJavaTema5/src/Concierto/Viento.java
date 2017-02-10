package Concierto;

public class Viento implements Instrumento {

    private String nombre;

    public Viento(String nombre) {
        this.nombre = nombre;
    }

    public String tocar() {
        return "Estoy soplando";
    }

   public String getNombre() {
        return nombre;
    }
}
