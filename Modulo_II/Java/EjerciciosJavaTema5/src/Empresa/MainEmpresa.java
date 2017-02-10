package Empresa;

import java.util.ArrayList;

public class MainEmpresa {
	
	
    public static void main(String[] args){
    	
    	Empleado empleado = new Empleado("Lara", "59867426K", 19, false, 12000.0);
        Programador programador1 = new Programador("Jorge", "50654634Y", 25, false, 25000.0, 700, "Java");
        Programador programador2 = new Programador("Jose", "6845635P", 40, true, 18000.0, 900, "PHP");

        ArrayList<Empleado> empleados = new ArrayList<>();

        empleados.add(programador1);
        empleados.add(programador2);
        empleados.add(empleado);


        for (Empleado empleado1 : empleados) {
                System.out.println(empleado1.toString());
            System.out.println();
        }
        
        System.out.println("***************************************************************");
        
        for (Empleado empleado1 : empleados) {
        	System.out.println("Aumento de salario en empleado:");
        	empleado1.aumentarSalario(8.0);
            System.out.println(empleado1.toString());
        System.out.println();
        }
    }

}
