package negocio;

import java.util.ArrayList;

import javax.ejb.Remote;

import beans.Celebrity;

@Remote
public interface GestionCelebrityRemote {

	public boolean aniadirCelebrity(Celebrity celebrity);
	public boolean modificarCelebrity(Celebrity celebrity);
	public ArrayList<Celebrity> listarCelebritys();
	public Celebrity listarCelebrityId(int idCelebrity);
	public ArrayList<Celebrity> listarCelebrityBuscada(String buscar);
	public ArrayList<Celebrity> listarCelebrityDirectores();
	public ArrayList<Celebrity> listarCelebrityActores();
}
