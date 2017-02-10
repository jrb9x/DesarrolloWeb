package dao;

import java.util.ArrayList;

import javax.ejb.Remote;

import beans.Pelicula;

@Remote
public interface PeliculaDaoRemote {

	public ArrayList<Pelicula> selectPelicula();
	public Pelicula selectPeliculaPorId(int idPelicula);
	public ArrayList<Pelicula> buscarPeliculas(String buscar);
	public boolean insertPelicula(Pelicula pelicula);
	public boolean updatePelicula(Pelicula p);
	public boolean deletePelicula(int idPelicula);
}
