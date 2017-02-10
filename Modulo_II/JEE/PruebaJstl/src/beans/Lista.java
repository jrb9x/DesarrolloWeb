package beans;

import java.util.*;

public class Lista {
	
	private List<String> listaDeNombres;
	
	public Lista() {
		listaDeNombres = new ArrayList<String>();
		listaDeNombres.add("Juan");
		listaDeNombres.add("Maria");
		listaDeNombres.add("Alberto");
		listaDeNombres.add("Lucia");
	}
	
	public List<String> getListaDeNombres() {
		return listaDeNombres;
	}
}