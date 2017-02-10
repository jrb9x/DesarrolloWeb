package negocio;

import java.util.ArrayList;

import javax.ejb.Local;

import beans.Celebrity;

@Local
public interface GestionCelebrityLocal {

	public boolean aniadirCelebrity(Celebrity celebrity);
	public boolean modificarCelebrity(Celebrity celebrity);
	public ArrayList<Celebrity> listarCelebritys();
	public Celebrity listarCelebrityId(int idCelebrity);
	public ArrayList<Celebrity> listarCelebrityBuscada(String buscar);
	public ArrayList<Celebrity> listarCelebrityDirectores();
	public ArrayList<Celebrity> listarCelebrityActores();
}
