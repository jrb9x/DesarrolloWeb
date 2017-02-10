package ejemplo;

//import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Prueba{

	public static void main(String[] args) {
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		//ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		Estudiante estudianteUno = (Estudiante) ac.getBean(Estudiante.class);
		Estudiante estudiante1 = (Estudiante) ac.getBean(Estudiante.class);
		/*
		
		Estudiante estudianteDos = (Estudiante) ac.getBean("estudianteDos");
		Estudiante estudianteTres = (Estudiante) ac.getBean("estudianteTres");
		Estudiante estudianteCuatro = (Estudiante) ac.getBean("estudianteCuatro");
		*/
		System.out.println(estudianteUno.toString());
		System.out.println(estudiante1.toString());
		/*
		System.out.println(estudianteUno.toString());
		System.out.println(estudianteDos.toString());
		System.out.println(estudianteTres.toString());
		System.out.println(estudianteCuatro.toString());
		*/
		ac.registerShutdownHook();
		ac.close();
	}

}
