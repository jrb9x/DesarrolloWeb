package model.business;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import beans.Tarea;

@Service
public interface ITareaBusiness {

	boolean aniadirTarea(Tarea tarea);
	boolean borrarTarea(Integer id);
	boolean actualizarTarea(Tarea tarea);
	Tarea recuperarTarea(Integer id);
	ArrayList<Tarea> recuperarTareasPor(boolean realizada);
	ArrayList<Tarea> recuperarTodasTareas();
}
