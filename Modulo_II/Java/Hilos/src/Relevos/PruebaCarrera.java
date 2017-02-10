package Relevos;

public class PruebaCarrera {

	public static void main(String[] args) {
		Atleta[] atletas ={ 
				new Atleta("alvaro"),
				new Atleta("victor"),
				new Atleta("juan"),
				new Atleta("pepe")
				};
		Carrera carrera = new Carrera(atletas);
		carrera.realizarCarrera();
	} 
}
