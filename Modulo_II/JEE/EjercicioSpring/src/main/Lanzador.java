package main;

import beans.Direccion;
import beans.PersonaEj1;

public class Lanzador {

	public static void main(String[] args) { 
		
		Direccion d = new Direccion(); 
		d.setCalle("Calle Maqueda"); 
		
		PersonaEj1 p = new PersonaEj1(); 
		p.setNombre("Jorge"); 
		p.setDireccion(d); 
		
		System.out.println(p); 
	}

}
