package Array;

import java.util.ArrayList;

public class Lista {

	public static void main(String[] args) {
		
		ArrayList<String> listaPaises = new ArrayList<String>();
		listaPaises.add("España");
		listaPaises.add("Italia");
		listaPaises.add(1, "Portugal");//posiciona en 1 y mueve el resto
		listaPaises.remove(2);
		listaPaises.remove("Italia");//elimina String en la posicion o con la misma cadena
		System.out.println(listaPaises.get(1));//Consulta en lista
		listaPaises.set(0, "Alemania");//modifica en la posicion
		
		String paisBuscado = "Portugal";
		int pos = listaPaises.indexOf(paisBuscado);
		if(pos!=-1)
			System.out.println(paisBuscado + " encontrado en la posición: "+pos);
		else
			System.out.println(paisBuscado + " no se ha encontrado");
		
		for (String pais : listaPaises) {
			System.out.println(pais);
		}
	}

}
