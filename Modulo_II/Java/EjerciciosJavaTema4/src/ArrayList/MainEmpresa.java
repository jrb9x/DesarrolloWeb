package ArrayList;

public class MainEmpresa {

	public static void main(String[] args) {
		Empresa empresa = new Empresa();
		Empleado empleado1= new Empleado("12313F",1500,12,24,16,2);
		Empleado empleado2= new Empleado("12313A",1500,6,24,16,0);
		Empleado empleado3= new Empleado("12313Y",1500,3,24,16,1);
		Empleado empleado4= new Empleado("12313Z",1500,2,24,16,3);
		
		System.out.println("Retenciones: " + empleado1.retenciones());
		
		empresa.aniadirEmpleado(empleado1);
		empresa.aniadirEmpleado(empleado2);
		empresa.aniadirEmpleado(empleado3);
		empresa.aniadirEmpleado(empleado4);
		
		Empleado encontrado = empresa.buscarEmpleadoPorNif("12313Z");
		empresa.borrarEmpleado(encontrado);
		System.out.println("La media de hijos es: " + empresa.mediaHijos());
		empresa.mostrarEmpleado("12313F");
		System.out.println("Empleado borrado: ");
		empresa.mostrarEmpleado("12313Z");
		empresa.mostrarEmleados();
	}

}
