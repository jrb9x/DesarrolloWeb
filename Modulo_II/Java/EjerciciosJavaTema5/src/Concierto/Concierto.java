package Concierto;

import java.util.ArrayList;

public class Concierto {

    public static void main(String[] args){
    	
        Instrumento flauta = new Flauta("flauta");
        Instrumento timbal = new Timbal("timbal");
        Instrumento violin = new Violin("violin");

        ArrayList<Instrumento> instrumento = new ArrayList<>();
        instrumento.add(flauta);
        instrumento.add(timbal);
        instrumento.add(violin);
        
        System.out.println(Orquesta.afinar(flauta));
        System.out.println(Orquesta.afinar(timbal));
        System.out.println(Orquesta.afinar(violin));

        System.out.println(Orquesta.comenzarConcierto());

        Orquesta orquesta = new Orquesta();
        orquesta.concierto(instrumento);

    }
}
