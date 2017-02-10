package prueba;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import beans.Descuento;
import beans.Peliculas;

public class Pruebas {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pruebaJPAEclipse");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Descuento descuento = new Descuento();
		descuento.setValue(50);
		descuento.setFechaFinal(LocalDate.now());
		
		Peliculas pelicula = new Peliculas();
		pelicula.setTitulo("titanic");
		pelicula.setDuracion(260);
		pelicula.setDescuento(descuento);
		
		try{
			tx.begin();
			em.persist(pelicula);
			tx.commit();
		}catch (Exception e) {
			tx.rollback();
		}
		
		/*
		Peliculas pelicula = new Peliculas();
		pelicula.setTitulo("Pelicula uno");
		pelicula.setDuracion(142);
		
		tx.begin();
		try {
			em.persist(pelicula);
			tx.commit();
			
			Peliculas p2 = em.find(Peliculas.class, 1);
			System.out.println("p2.titulo: " + p2.getTitulo());
			System.out.println("p2==pelicula:" + (p2==pelicula));
			
		} catch(Exception e) {
			tx.rollback();
		}*/
		em.close();
		emf.close();
	}
}