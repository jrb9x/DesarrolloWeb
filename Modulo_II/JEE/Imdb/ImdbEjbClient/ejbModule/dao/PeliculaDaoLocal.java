package dao;

import java.util.ArrayList;

import javax.ejb.Local;

import beans.Pelicula;

@Local
public interface PeliculaDaoLocal {

	public ArrayList<Pelicula> selectPelicula();
	public Pelicula selectPeliculaPorId(int idPelicula);
	public ArrayList<Pelicula> buscarPeliculas(String buscar);
	public boolean insertPelicula(Pelicula pelicula);
	public boolean updatePelicula(Pelicula p);
	public boolean deletePelicula(int idPelicula);
}
