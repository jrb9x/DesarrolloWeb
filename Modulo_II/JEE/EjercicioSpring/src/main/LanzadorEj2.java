package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.PersonaEj2;

public class LanzadorEj2 {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[]{"beansEj2.xml "});

		PersonaEj2 personaUno = (PersonaEj2)appContext.getBean("personaUno");
		PersonaEj2 personaDos = (PersonaEj2)appContext.getBean("personaDos");
		PersonaEj2 personaTres = (PersonaEj2)appContext.getBean("personaTres");
		
		System.out.println(personaUno);
		System.out.println(personaDos);
		System.out.println(personaTres);

	}

}
