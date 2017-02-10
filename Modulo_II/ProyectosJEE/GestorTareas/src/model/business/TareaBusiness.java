package model.business;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import beans.Tarea;
import model.dao.ITareaDao;

@Service
@Transactional
public class TareaBusiness implements ITareaBusiness {

	@Autowired
	private ITareaDao tareaDao;
	
	@Override
	public boolean aniadirTarea(Tarea tarea) {
		
		return tareaDao.inserTarea(tarea);
	}

	@Override
	public boolean borrarTarea(Integer id) {

		return tareaDao.deleteTarea(id);
	}

	@Override
	public boolean actualizarTarea(Tarea tarea) {
	
		return tareaDao.updateTarea(tarea);
	}

	@Override
	public Tarea recuperarTarea(Integer id) {
		return tareaDao.selectTarea(id);
	}

	@Override
	public ArrayList<Tarea> recuperarTodasTareas() {
		return tareaDao.selectTodasTareas();
	}

	@Override
	public ArrayList<Tarea> recuperarTareasPor(boolean realizada) {
		
		return tareaDao.selectTareasPor(realizada);
	}

}
