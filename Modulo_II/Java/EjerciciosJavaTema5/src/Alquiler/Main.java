package Alquiler;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args){
    	
    	Coche coche = new Coche("6842 BBB", 60000.0, true, false);
        Furgoneta furgoneta1 = new Furgoneta("3156 KRN", 3000.0, false, 475000);
        Furgoneta furgoneta2 = new Furgoneta("3156 KRN", 4000.0, false, 475000);
        Moto moto = new Moto("7821 JRB", 12000.0, false, false);

        ArrayList<Vehiculo> vehiculo = new ArrayList<>();

        vehiculo.add(coche);
        vehiculo.add(furgoneta1);
        vehiculo.add(furgoneta2);
        vehiculo.add(moto);

        //((moto)v)setCasco(true);
        
        for (Vehiculo vehiculos : vehiculo) {
                System.out.println(vehiculos.toString());
            System.out.println();
        }
        
        System.out.println("***************************************************************");
        
        System.out.println(coche.alquilarVehiculo());
        System.out.println(furgoneta2.alquilarVehiculo());
        System.out.println(moto.alquilarVehiculo());
        
        
    }

}

