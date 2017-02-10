package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.PersonaEj4;

public class LanzadorEj4 {

	public static void main(String[] args) {

		ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[]{"beansEj4.xml "});
		
		PersonaEj4 personaUno = (PersonaEj4)appContext.getBean("personaUno");
		PersonaEj4 personaDos = (PersonaEj4)appContext.getBean("personaDos");
		PersonaEj4 personaTres = (PersonaEj4)appContext.getBean("personaTres");
		
		System.out.println(personaUno);
		System.out.println(personaDos);
		System.out.println(personaTres);
	}

}
