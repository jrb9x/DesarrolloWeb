package dao;

import java.util.ArrayList;

import javax.ejb.Remote;

import beans.Celebrity;

@Remote
public interface CelebrityDaoRemote {

	public ArrayList<Celebrity> selectCelebrity();
	public Celebrity selectPeliculaPorId(int idCelebrity);
	public ArrayList<Celebrity> buscarCelebritys(String buscar);
	public boolean updateCelebrity(Celebrity c);
	public boolean deleteCelebrity(int idCelebrity);
	public ArrayList<Celebrity> buscarCelebritysDirectores();
	public ArrayList<Celebrity> buscarCelebritysActores();
}
