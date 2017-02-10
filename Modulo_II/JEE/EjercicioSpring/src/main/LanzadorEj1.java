package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.PersonaEj1;

public class LanzadorEj1 {

	public static void main(String[] args){
		ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[]{"beansEj1.xml "});
		
		PersonaEj1 personaUno = (PersonaEj1)appContext.getBean("persona");
		PersonaEj1 personaDos = (PersonaEj1)appContext.getBean("persona");
		
		System.out.println(personaUno);
		System.out.println(personaDos);
		
		}


}
