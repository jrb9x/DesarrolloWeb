package model.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import beans.Tarea;

@Repository
public class TareaDao implements ITareaDao{

	@PersistenceContext
	EntityManager em;

	@Override
	public boolean inserTarea(Tarea tarea) {
		em.persist(tarea);
		return true;
	}

	@Override
	public Tarea selectTarea(Integer id) {
		Tarea tarea = em.find(Tarea.class, id);
		return tarea;
	}

	@Override
	public boolean deleteTarea(Integer id) {
		Tarea tarea = em.find(Tarea.class, id);
		em.remove(tarea);
		return true;
	}

	@Override
	public boolean updateTarea(Tarea tarea) {
		em.merge(tarea);
		return true;
	}

	@Override
	public ArrayList<Tarea> selectTodasTareas() {
		ArrayList<Tarea> aux = new ArrayList<Tarea>();
		String jpql = "SELECT tarea FROM Tarea tarea";
		Query query = em.createQuery(jpql);
		aux = (ArrayList<Tarea>) query.getResultList();
		
		return aux;
	}

	@Override
	public ArrayList<Tarea> selectTareasPor(boolean realizada) {
		ArrayList<Tarea> aux = new ArrayList<Tarea>();
		ArrayList<Tarea> resultados = selectTodasTareas();
		for(Tarea tarea : resultados) {
			if(tarea.isRealizada()==realizada){
				aux.add(tarea);
			}
		}
		return aux;
	}
	
}
