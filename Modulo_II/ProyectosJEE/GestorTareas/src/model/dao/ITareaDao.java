package model.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import beans.Tarea;

@Repository
public interface ITareaDao {

	boolean inserTarea(Tarea tarea);
	Tarea selectTarea(Integer id);
	boolean deleteTarea(Integer id);
	boolean updateTarea(Tarea tarea);
	ArrayList<Tarea> selectTodasTareas();
	ArrayList<Tarea> selectTareasPor(boolean realizada);
	
}
