package Herencia;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class Pruebas {

	public static void main(String[] args) throws IOException {
		Bombero b = new Bombero();
		
		ObjectOutputStream escritorObjetos = new ObjectOutputStream(System.out);
		
		escritorObjetos.writeObject(b);
		
		b.anioExperiencia();
		System.out.println(b.toString());

	}

}
